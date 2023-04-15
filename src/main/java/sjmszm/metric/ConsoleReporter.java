package sjmszm.metric;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 1.根据给定的时间区间，从数据库中拉取数据;
 * 2.将统计数据显示到终端（命令行或邮件）；
 * 4.将统计数据显示到终端（命令行或邮件）；
 */
public class ConsoleReporter {

    private MetricsStorage metricsStorage;
    private ScheduledExecutorService executor;

    public ConsoleReporter(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    /**
     * 函数存在的问题：
     * 1. ConsoleReporter 和 EmailReporter 两个类中存在代码重复问题。
     *    在这两个类中，从数据库中取数据、做统计的逻辑都是相同的，可以抽取出来复用，否则就违反了 DRY 原则。
     *
     * 2. 整个类负责的事情比较多，不相干的逻辑糅合在里面，职责不够单一。特别是显示部分的代码可能会比较复杂
     *    （比如 Email 的显示方式），最好能将这部分显示逻辑剥离出来，设计成一个独立的类。
     *
     * 3.为代码中涉及线程操作，并且调用了 Aggregator 的静态函数
     * @param periodInSeconds
     * @param durationInSeconds
     */
    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long durationInMillis = durationInSeconds * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;

                Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
                HashMap<String, RequestStat> stats = new HashMap<>();
                for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
                    String apiName = entry.getKey();
                    List<RequestInfo> requestInfoPerApi = entry.getValue();
                    RequestStat requestStat = Aggregator.aggregate(requestInfoPerApi, durationInMillis);
                    stats.put(apiName,requestStat);
                }

                System.out.println("Time Span: [" + startTimeInMillis + "," + endTimeInMillis + "]");
                Gson gson = new Gson();
                System.out.println(gson.toJson(stats));

            }
        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }
}
