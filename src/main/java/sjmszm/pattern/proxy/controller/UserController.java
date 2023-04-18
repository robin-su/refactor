package sjmszm.pattern.proxy.controller;

import sjmszm.pattern.proxy.MetricsCollector;
import sjmszm.pattern.proxy.RequestInfo;
import sjmszm.pattern.proxy.UserVo;

/**
 * 存在的问题：
 * 1. 性能计数器框架代码侵入到业务代码中，跟业务代码高度耦合。如果未来需要替换这个框架，那替换的成本会比较大。
 * 2. 收集接口请求的代码跟业务代码无关，本就不应该放到一个类中。业务类最好职责更加单一，只聚焦业务处理。
 */
public class UserController {

    // 依赖注入
    private MetricsCollector metricsCollector;

    public UserVo login(final String telephone, final String password) {
        long startTimestamp = System.currentTimeMillis();
        // 省略login逻辑
        long endTimestamp = System.currentTimeMillis();
        long responseTime = endTimestamp - startTimestamp;

        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        // ... 返回UserVo数据
        return null;
    }

    public UserVo register(final String telephone, final String password) {
        long startTimestamp = System.currentTimeMillis();
        //... 省略register逻辑
        long endTimestamp = System.currentTimeMillis();
        long responseTime = endTimestamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return null;
    }


}
