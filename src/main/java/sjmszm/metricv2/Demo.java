package sjmszm.metricv2;

public class Demo {

    public static void main(String[] args) {
        /**
         * 框架用起来还是稍微有些复杂的，需要组装各种类，比如需要创建 MetricsStorage 对象、Aggregator 对象、
         * ConsoleViewer 对象，然后注入到 ConsoleReporter 中，才能使用 ConsoleReporter。除此之外，还有
         * 可能存在误用的情况，比如把 EmailViewer 传递进了 ConsoleReporter 中。
         * 总体上来讲，框架的使用方式暴露了太多细节给用户，过于灵活也带来了易用性的降低。
         *
         *
         * 为了让框架用起来更加简单（能将组装的细节封装在框架中，不暴露给框架使用者），又不失灵活性（可以自由组装不同的
         * MetricsStorage 实现类、StatViewer 实现类到 ConsoleReporter 或 EmailReporter），也不降低代码的可测试性
         * （通过依赖注入来组装类，方便在单元测试中 mock），我们可以额外地提供一些封装了默认依赖的构造函数，让使用者自主选择
         * 使用哪种构造函数来构造对象。
         */
        MetricsStorage storage = new RedisMetricsStorage();
        Aggregator aggregator = new Aggregator();
        // 定时触发统计并将结果显示到终端 ConsoleViewer
        ConsoleViewer consoleViewer = new ConsoleViewer();
        ConsoleReporter consoleReporter = new ConsoleReporter(storage,aggregator,consoleViewer);
        consoleReporter.startRepeatedReport(60,60);

        // 定时触发统计并将结果输出到邮件
        EmailViewer emailViewer = new EmailViewer();
        emailViewer.addToAddress("wangzheng@xzg.com");
        EmailReporter emailReporter = new EmailReporter(storage,aggregator,emailViewer);
        emailReporter.startDailyReport();

        MetricsCollector collector = new MetricsCollector(storage);
        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 11234));
        collector.recordRequest(new RequestInfo("register", 323, 12334));
        collector.recordRequest(new RequestInfo("login", 23, 12434));
        collector.recordRequest(new RequestInfo("login", 1223, 14234));
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
