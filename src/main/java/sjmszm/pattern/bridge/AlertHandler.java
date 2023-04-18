package sjmszm.pattern.bridge;

abstract class AlertHandler {

    private AlertRule rule;
    private Notification notification;

    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public abstract void check(ApiStatInfo apiStatInfo);

    protected AlertRule getRule() {
        return rule;
    }

    protected Notification getNotification() {
        return notification;
    }


}
