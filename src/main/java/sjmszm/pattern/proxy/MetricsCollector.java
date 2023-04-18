package sjmszm.pattern.proxy;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.Executors;

/**
 * 类负责提供 API，来采集接口请求的原始数据。
 * 负责打点采集原始数据，包括记录每次接口请求的响应时间和请求时间戳，
 * 并调用 MetricsStorage 提供的接口来存储这些原始数据。
 *
 *
 * 1. 一个是采集和存储要异步来执行，因为存储基于外部存储（比如 Redis），会比较慢，异步存储可以降低对接口响应时间的影响。
 * 2. 另一个是当需要聚合统计的数据量比较大的时候，一次性加载太多的数据到内存，有可能会导致内存吃紧，甚至内存溢出，这样整
 * 个系统都会瘫痪掉。
 *
 * 1.我们通过在MetricsCollector中引入Google Guava EventBus来解决。实际上，我们可以把EventBus看作一个“生产者-消费者”模型
 * 或者“发布-订阅”模型，采集的数据先放入内存共享队列中，另一个线程读取共享队列中的数据，写入到外部存储（比如 Redis）中.
 * 2.针对第二个问题，解决的思路比较简单，但代码实现稍微有点复杂。当统计的时间间隔较大的时候，需要统计的数据量就会比较大。我们可以将其
 * 划分为一些小的时间区间（比如 10 分钟作为一个统计单元），针对每个小的时间区间分别进行统计，然后将统计得到的结果再进行聚合，得到最终
 * 整个时间区间的统计结果。不过，这个思路只适合响应时间的max、min、avg，及其接口请求count、tps的统计，对于响应时间的percentile
 * 的统计并不适用。
 * 3.对于 percentile 的统计要稍微复杂一些，具体的解决思路是这样子的：我们分批从 Redis 中读取数据，然后存储到文件中，再根据响应时间
 * 从小到大利用外部排序算法来进行排序。排序完成之后，再从文件中读取第count*percentile（count 表示总的数据个数，percentile就是百
 * 分比，99 百分位就是 0.99）个数据，就是对应的percentile响应时间。
 */
public class MetricsCollector {

    private static final int DEFAULT_STORAGE_THREAD_POOL_SIZE = 20;
    private MetricsStorage metricsStorage; // 基于接口而非实现编程
    private EventBus eventBus;


    /**
     * 兼顾代码的易用性，新增一个封装了默认依赖的构造函数
     */
    public MetricsCollector() {
        this(new RedisMetricsStorage());
    }

    public MetricsCollector(MetricsStorage metricsStorage) {
        this(metricsStorage,DEFAULT_STORAGE_THREAD_POOL_SIZE);
    }

    public MetricsCollector(MetricsStorage metricsStorage, int threadNumToSaveData) {
        this.metricsStorage = metricsStorage;
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(threadNumToSaveData));
        this.eventBus.register(new EventListener());
    }

    public void recordRequest(RequestInfo requestInfo) {
        if(requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }
//        metricsStorage.saveRequestInfo(requestInfo);
        eventBus.post(requestInfo);
    }

    public class EventListener {
        @Subscribe
        public void saveRequestInfo(RequestInfo requestInfo) {
            metricsStorage.saveRequestInfo(requestInfo);
        }
    }

}
