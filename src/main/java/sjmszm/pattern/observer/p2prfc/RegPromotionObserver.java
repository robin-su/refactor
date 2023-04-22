package sjmszm.pattern.observer.p2prfc;

import sjmszm.pattern.observer.p2p.PromotionService;

public class RegPromotionObserver implements RegObserver {
    // 依赖注入
    PromotionService promotionService;

    @Override
    public void handleRegSuccess(Long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
