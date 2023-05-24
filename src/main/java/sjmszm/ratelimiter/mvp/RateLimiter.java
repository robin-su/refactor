package sjmszm.ratelimiter.mvp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;
import sjmszm.ratelimiter.mvp.alg.RateLimitAlg;
import sjmszm.ratelimiter.mvp.exception.InternalErrorException;
import sjmszm.ratelimiter.mvp.rule.AppLimit;
import sjmszm.ratelimiter.mvp.rule.RateLimitRule;
import sjmszm.ratelimiter.mvp.rule.RuleConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * RateLimiter 类用来串联整个限流流程。它先读取限流规则配置文件，映射为内存中的 Java 对象（RuleConfig），然后再将这个中间结构构建成
 * 一个支持快速查询的数据结构（RateLimitRule）。除此之外，这个类还提供供用户直接使用的最顶层接口（limit() 接口）。
 *
 * 存在的问题：，RateLimiter 类作为执行入口，我们希望它只负责组装工作，而不应该包含具体的业务逻辑，所以，RateLimiter 类中，
 * 从配置文件中读取限流规则这块逻辑，应该拆分出来设计成独立的类。
 */
public class RateLimiter {

    private static final Logger logger = LoggerFactory.getLogger(RateLimiter.class);

    // 为每个API在内存中存储限流计数器
    private ConcurrentMap<String, RateLimitAlg> counters = new ConcurrentHashMap<>();
    private RateLimitRule rule;

    public RateLimiter() {
        // 将限流规则配置文件ratelimiter-rule.yaml中的内容读取到RuleConfig中
        InputStream in = null;
        RuleConfig ruleConfig = null;
        try {
            in = this.getClass().getResourceAsStream("/mvp/ratelimiter-rule.yaml");
            if(in != null) {
                Yaml yaml = new Yaml();
                ruleConfig = yaml.loadAs(in, RuleConfig.class);
            }
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("close file error:{}", e);
                }
            }
        }
        // 将限流规则构建成支持快速查找的数据结构RateLimitRule
        this.rule = new RateLimitRule(ruleConfig);
    }

    public boolean limit(String appId,String url) throws InternalErrorException {
        AppLimit apiLimit = rule.getLimit(appId, url);
        if(apiLimit == null) {
            return true;
        }
        // 获取api对应在内存中的限流计数器（rateLimitCounter）
        String counterKey = appId + ":" + apiLimit.getApi();
        RateLimitAlg rateLimitCounter = counters.get(counterKey);
        if(rateLimitCounter == null) {
            RateLimitAlg newRateLimitCounter = new RateLimitAlg(apiLimit.getLimit());
            rateLimitCounter = counters.putIfAbsent(counterKey, newRateLimitCounter);
            if(rateLimitCounter  == null) {
                rateLimitCounter =  newRateLimitCounter;
            }
        }
        return rateLimitCounter.tryAcquire();
    }


}
