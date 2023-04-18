package sjmszm.pattern.proxy;

import java.util.*;

/**
 * ConsoleReporter、EmailReporter 类仍然存在代码重复、可测试性差的问题。
 */
public class EmailReporter extends ScheduledReporter {

    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    // 兼顾代码的易用性，新增一个封装了默认依赖的构造函数
    public EmailReporter(List emailToAddresses) {
        this(new RedisMetricsStorage(), new Aggregator(), new EmailViewer(emailToAddresses));
    }

    // 兼顾灵活性和代码的可测试性，这个构造函数继续保留
    public EmailReporter(MetricsStorage metricsStorage,
                         Aggregator aggregator,
                         StatViewer viewer) {
        super(metricsStorage, aggregator, viewer);
    }

    /**
     * EmailReporter 可测试性不好，一方面是因为用到了线程（定时器也相当于多线程），另一方面是因为涉及时间的计算逻辑。
     */
    public void startDailyReport() {
        Date firstTime = trimTimeFieldsToZeroOfNextDay(new Date());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                doStartDailyReport(startTimeInMillis, endTimeInMillis);
            }
        },firstTime,DAY_HOURS_IN_SECONDS * 1000);
    }

    private Date trimTimeFieldsToZeroOfNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 重新设置时间，为了增加可测试性
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date firstTime = calendar.getTime();
        return firstTime;
    }

    /**
     * long durationInMillis = durationInSeconds * 1000;
     *                 long endTimeInMillis = System.currentTimeMillis();
     *                 long startTimeInMillis = endTimeInMillis - durationInMillis;
     *
     *                 Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
     *                 Map<String, RequestStat> stats = aggregator.aggregate(durationInSeconds, requestInfos);
     *                 statViewer.output(stats,startTimeInMillis,endTimeInMillis);
     */



}
