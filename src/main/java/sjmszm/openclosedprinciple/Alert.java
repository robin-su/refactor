package sjmszm.openclosedprinciple;

class Alert {

    private AlertRule rule;
    private Notification notification;

    public Alert(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public void check(String api, long requestCount,long errorCount, long durationOfSeconds) {
        long tps = requestCount / durationOfSeconds;
        if(tps > rule.getMatchedRule(api).getMaxTps()) {
            notification.toNotify(NotificationEmergencyLevel.URGENCY,"...");
        }
        if(errorCount > rule.getMatchedRule(api).getMaxErrorCount()) {
            notification.toNotify(NotificationEmergencyLevel.SEVERE,"...");
        }
    }


}
