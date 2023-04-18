package sjmszm.pattern.bridge;

public class ErrorAlertHandler extends AlertHandler {

    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if(apiStatInfo.getErrorCount() > getRule().getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount()) {
            getNotification().notify(NotificationEmergencyLevel.SEVERE,"...");
        }
    }

}
