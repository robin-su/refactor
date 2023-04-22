package sjmszm.pattern.observer.p2pAsyncEasy;

import sjmszm.pattern.observer.p2p.PromotionService;

public class AsyncRegPromotionObserver implements RegObserver {

    private PromotionService promotionService; // 依赖注入

    @Override
    public void handleRegSuccess(Long userId) {
        // 第一种实现方式，频繁地创建和销毁线程比较耗时，并且并发线程数无法控制，创建过多的线程会导致堆栈溢出。
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                promotionService.issueNewUserExperienceCash(userId);
            }
        });
        thread.start();
    }
}
