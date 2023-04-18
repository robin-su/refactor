package sjmszm.pattern.proxy;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * ConsoleReporter、EmailReporter 类仍然存在代码重复、可测试性差的问题。
 *
 * 1.根据给定的时间区间，从数据库中拉取数据;
 * 2.将统计数据显示到终端（命令行或邮件）；
 * 4.将统计数据显示到终端（命令行或邮件）；
 */
public class ConsoleReporter extends ScheduledReporter {

    private ScheduledExecutorService executor;

    private static AtomicBoolean stopped = new AtomicBoolean(false);

    // 兼顾代码的易用性，新增一个封装了默认依赖的构造函数
    public ConsoleReporter() {
        this(new RedisMetricsStorage(),new Aggregator(),new ConsoleViewer());
    }

    // 兼顾灵活性和代码的可测试性，这个构造函数继续保留
    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer statViewer) {
        super(metricsStorage, aggregator, statViewer);
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    /**
     * ConsoleReporter可测试性不好，一方面是因为用到了线程（定时器也相当于多线程），另一方面是因为涉及时间的计算逻辑。
     *
     * @param periodInSeconds
     * @param durationInSeconds
     */
    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        if(!stopped.get()) {
            executor.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    long durationInMillis = durationInSeconds * 1000;
                    long endTimeInMillis = System.currentTimeMillis();
                    long startTimeInMillis = endTimeInMillis - durationInMillis;
                    doStartDailyReport(startTimeInMillis, endTimeInMillis);
                    stopped.set(true);
                }
            }, 0, periodInSeconds, TimeUnit.SECONDS);
        }

    }
}
