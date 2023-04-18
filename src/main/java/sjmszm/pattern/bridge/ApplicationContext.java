package sjmszm.pattern.bridge;

public class ApplicationContext {

    private AlertRule alertRule;
    private Notification notification;
    private Alert alter;


    public void initializeBeans() {
        alertRule = new AlertRule(null/*省略参数*/);
        notification = new Notification();
        alter = new Alert();
        alter.addAlert(new TpsAlertHandler(alertRule,notification));
        alter.addAlert(new ErrorAlertHandler(alertRule,notification));
    }

    public Alert getAlter() {
        return alter;
    }

    private static final ApplicationContext instance = new ApplicationContext();

    private ApplicationContext() {
        this.initializeBeans(); //注意这里不能是instance。此时instance还没初始化出来
    }

    public static ApplicationContext getInstance() {
        return new ApplicationContext();
    }


}
