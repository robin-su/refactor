package sjmszm.pattern.proxy.controllerrfc;

import sjmszm.pattern.proxy.MetricsCollector;
import sjmszm.pattern.proxy.RequestInfo;
import sjmszm.pattern.proxy.UserVo;
import sjmszm.pattern.proxy.controller.UserController;

/**
 * 问题：如果原始类并没有定义接口，并且原始类代码并不是我们开发维护的（比如它来自一个第三方的类库），
 * 我们也没办法直接修改原始类，给它重新定义一个接口。在这种情况下，我们该如何实现代理模式呢？
 * 答案：对于这种外部类的扩展，我们一般都是采用继承的方式。这里也不例外。我们让代理类继承原始类，然后扩展附加功能。
 * 详细见：controllerrfc2包中所定义
 *
 */
public class UserControllerProxy implements IUserController {

    private MetricsCollector metricsCollector;
    private UserController userController;

    public UserControllerProxy(UserController userController) {
        this.userController = userController;
        this.metricsCollector = new MetricsCollector();
    }

    @Override
    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        UserVo userVo = userController.login(telephone, password);

        long endTimestamp = System.currentTimeMillis();
        long responseTime = endTimestamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);

        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        UserVo userVo = userController.register(telephone, password);

        long endTimestamp = System.currentTimeMillis();
        long responseTimestamp = endTimestamp - startTimestamp;

        RequestInfo requestInfo = new RequestInfo("register", responseTimestamp, startTimestamp);

        metricsCollector.recordRequest(requestInfo);

        return userVo;
    }
}
