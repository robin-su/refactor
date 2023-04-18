package sjmszm.pattern.bridge;

public class TpsAlertHandler extends AlertHandler {

    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
        if(tps > getRule().getMatchedRule(apiStatInfo.getApi()).getMaxTps()) {
            getNotification().notify(NotificationEmergencyLevel.URGENCY,"...");
        }
    }

}
