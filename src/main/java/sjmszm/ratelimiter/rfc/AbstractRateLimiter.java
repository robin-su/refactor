package sjmszm.ratelimiter.rfc;

import sjmszm.ratelimiter.rfc.alg.FixedTimeWindowRateLimiter;
import sjmszm.ratelimiter.rfc.alg.RateLimitAlg;
import sjmszm.ratelimiter.rfc.datasource.FileRuleConfigSource;
import sjmszm.ratelimiter.rfc.datasource.RuleConfigSource;
import sjmszm.ratelimiter.rfc.exception.InternalErrorException;
import sjmszm.ratelimiter.rfc.rule.AppLimit;
import sjmszm.ratelimiter.rfc.rule.RateLimitRule;
import sjmszm.ratelimiter.rfc.rule.RuleConfig;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * RateLimiter 类用来串联整个限流流程。它先读取限流规则配置文件，映射为内存中的 Java 对象（RuleConfig），然后再将这个中间结构构建成
 * 一个支持快速查询的数据结构（RateLimitRule）。除此之外，这个类还提供供用户直接使用的最顶层接口（limit() 接口）。
 *
 * 存在的问题：，RateLimiter 类作为执行入口，我们希望它只负责组装工作，而不应该包含具体的业务逻辑，所以，RateLimiter 类中，
 * 从配置文件中读取限流规则这块逻辑，应该拆分出来设计成独立的类。
 */
public abstract class AbstractRateLimiter {

    // 为每个API在内存中存储限流计数器
    private ConcurrentMap<String, RateLimitAlg> counters = new ConcurrentHashMap<>();
    private RateLimitRule rule;

    private RuleConfigSource configSource;

    /**
     * 1.盖函数存在问题，可拓展性比较差：
     * 1）限定了只能使用本地配置：FileRuleConfigSource
     * 2）
     */
    public AbstractRateLimiter(RuleConfigSource configSource) {
        this.configSource = configSource;
        RuleConfig ruleConfig = configSource.load();
        // 将限流规则构建成支持快速查找的数据结构RateLimitRule
        this.rule = new RateLimitRule(ruleConfig);
    }

    /**
     *  1.该算法限定了基于内存的单机限流算法。可拓展性比较差。
     */
    public boolean limit(String appId,String url) throws InternalErrorException {
        AppLimit apiLimit = rule.getLimit(appId, url);
        if(apiLimit == null) {
            return true;
        }
        // 获取api对应在内存中的限流计数器（rateLimitCounter）
        RateLimitAlg rateLimitCounter = getRateLimiterAlgorithm(appId, apiLimit.getApi(),apiLimit.getLimit());
        return rateLimitCounter.tryAcquire();
    }



    /**
     * 获取限流算法:该方法限定了基于内存的单机限流算法。可拓展性比较差。
     * @param appId
     * @param api
     * @param limit
     * @return
     */
    private RateLimitAlg getRateLimiterAlgorithm(String appId, String api, int limit) {
        String counterKey = generateUrlKey(appId, api);
        RateLimitAlg rateLimitCounter = counters.get(counterKey);
        if(rateLimitCounter == null) {
            RateLimitAlg newRateLimitCounter = createRateLimiterAlgorithm(limit);
            rateLimitCounter = counters.putIfAbsent(counterKey, newRateLimitCounter);
            if(rateLimitCounter  == null) {
                rateLimitCounter =  newRateLimitCounter;
            }
        }
        return rateLimitCounter;
    }

    protected abstract RateLimitAlg createRateLimiterAlgorithm(int limit);

    private static String generateUrlKey(String appId, String api) {
        StringBuilder builder = new StringBuilder();
        return builder.append(appId)
                .append(":")
                .append(api)
                .toString();
    }


}
