package sjmszm.pattern.observer.p2pAsyncEasy;

import sjmszm.pattern.observer.p2p.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class UserController {

    private UserService userService; // 依赖注入
    private List<RegObserver> regObservers = new ArrayList<>();

    private Executor executor;

    public UserController(Executor executor) {
        this.executor = executor;
    }

    public void setRegObservers(List<RegObserver> regObservers) {
        regObservers.addAll(regObservers);
    }

    public long register(String telephone,String password) {
        // 省略输入参数校验代码
        long userId = userService.register(telephone, password);
        //第二种实现方式，尽管利用了线程池解决了第一种实现方式的问题，但线程池、异步执行逻辑都耦合在了register()
        // 函数中，增加了这部分业务代码的维护成本。
        for (RegObserver observer : regObservers) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observer.handleRegSuccess(userId);
                }
            });
        }
        return userId;
    }

}
