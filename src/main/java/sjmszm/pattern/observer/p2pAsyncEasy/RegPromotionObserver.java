package sjmszm.pattern.observer.p2pAsyncEasy;

import sjmszm.pattern.observer.p2p.PromotionService;

public class RegPromotionObserver implements RegObserver {

    private PromotionService promotionService; // 依赖注入

    @Override
    public void handleRegSuccess(Long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
