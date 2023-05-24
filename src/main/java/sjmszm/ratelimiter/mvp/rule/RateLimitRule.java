package sjmszm.ratelimiter.mvp.rule;

public class RateLimitRule {

    private RuleConfig ruleConfig;

    public RateLimitRule(RuleConfig ruleConfig) {
        this.ruleConfig = ruleConfig;
    }

    public AppLimit getLimit(String appId, String api) {
        return null;
    }

}
