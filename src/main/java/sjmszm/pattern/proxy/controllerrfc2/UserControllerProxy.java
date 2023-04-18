package sjmszm.pattern.proxy.controllerrfc2;

import sjmszm.pattern.proxy.MetricsCollector;
import sjmszm.pattern.proxy.RequestInfo;
import sjmszm.pattern.proxy.UserVo;
import sjmszm.pattern.proxy.controller.UserController;

/**
 * 还是有问题：
 * 1. 一方面，我们需要在代理类中，将原始类中的所有的方法，都重新实现一遍，并且为每个方法都附加相似的代码逻辑。
 * 2. 另一方面，如果要添加的附加功能的类有不止一个，我们需要针对每个类都创建一个代理类。
 * 3.如果有 50 个要添加附加功能的原始类，那我们就要创建 50 个对应的代理类。这会导致项目中类的个数成倍增加，增加了代码维护成本。
 * 并且，每个代理类中的代码都有点像模板式的“重复”代码，也增加了不必要的开发成本。那这个问题怎么解决呢？
 *
 * 解决方案：
 * 1.我们可以使用动态代理来解决这个问题。所谓动态代理（Dynamic Proxy），就是我们不事先为每个原始类编写代理类，
 * 而是在运行的时候，动态地创建原始类对应的代理类.
 * 2.因为 Java 语言本身就已经提供了动态代理的语法（实际上，动态代理底层依赖的就是 Java 的反射语法）
 */
public class UserControllerProxy extends UserController {

    private MetricsCollector metricsCollector;

    public UserControllerProxy() {
        this.metricsCollector = new MetricsCollector();
    }

    @Override
    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        UserVo userVo = super.login(telephone, password);

        long endTimestamp = System.currentTimeMillis();
        long responseTime = endTimestamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);

        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        UserVo userVo = super.register(telephone, password);

        long endTimestamp = System.currentTimeMillis();
        long responseTimestamp = endTimestamp - startTimestamp;

        RequestInfo requestInfo = new RequestInfo("register", responseTimestamp, startTimestamp);

        metricsCollector.recordRequest(requestInfo);

        return userVo;
    }
}
