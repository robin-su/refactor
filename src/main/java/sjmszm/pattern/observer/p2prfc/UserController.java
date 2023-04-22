package sjmszm.pattern.observer.p2prfc;

import sjmszm.pattern.observer.p2p.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    private UserService userService; // 依赖注入
    private List<RegObserver> regObserverList = new ArrayList<>();

    // 一次性设置好，之后也不可能动态的修改
    public void setRegObservers(List<RegObserver> observers) {
        regObserverList.addAll(observers);
    }

    public Long register(String telephone, String password) {
        long userId = userService.register(telephone, password);
        for (RegObserver observer : regObserverList) {
            observer.handleRegSuccess(userId);
        }
        return userId;
    }

}
