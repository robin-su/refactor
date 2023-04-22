package sjmszm.pattern.observer.p2prfc;

public class RegNotificationObserver implements RegObserver{

    NotificationService notificationService;

    @Override
    public void handleRegSuccess(Long userId) {
        notificationService.sendInboxMessage(userId,"welcome...");
    }
}
