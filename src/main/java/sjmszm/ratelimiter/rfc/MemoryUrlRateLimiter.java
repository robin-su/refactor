package sjmszm.ratelimiter.rfc;

import sjmszm.ratelimiter.rfc.alg.FixedTimeWindowRateLimiter;
import sjmszm.ratelimiter.rfc.alg.RateLimitAlg;
import sjmszm.ratelimiter.rfc.datasource.RuleConfigSource;

public class MemoryUrlRateLimiter extends AbstractRateLimiter {
    /**
     * 1.盖函数存在问题，可拓展性比较差：
     * 1）限定了只能使用本地配置：FileRuleConfigSource
     * 2）
     *
     * @param configSource
     */
    public MemoryUrlRateLimiter(RuleConfigSource configSource) {
        super(configSource);
    }

    @Override
    protected RateLimitAlg createRateLimiterAlgorithm(int limit) {
        return new FixedTimeWindowRateLimiter(limit);
    }
}
