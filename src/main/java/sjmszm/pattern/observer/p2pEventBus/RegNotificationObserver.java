package sjmszm.pattern.observer.p2pEventBus;

import com.google.common.eventbus.Subscribe;
import sjmszm.pattern.observer.p2prfc.NotificationService;

public class RegNotificationObserver {
    // 依赖注入
    private NotificationService notificationService;

    @Subscribe
    public void handleRegSuccess(Long userId) {
        notificationService.sendInboxMessage(userId, "...");
    }

}
