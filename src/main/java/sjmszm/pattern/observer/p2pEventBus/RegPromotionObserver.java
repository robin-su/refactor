package sjmszm.pattern.observer.p2pEventBus;

import com.google.common.eventbus.Subscribe;
import sjmszm.pattern.observer.p2pAsyncEasy.PromotionService;

public class RegPromotionObserver {

    private PromotionService promotionService; // 依赖注入

    @Subscribe
    public void handleRegSuccess(Long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }





}
