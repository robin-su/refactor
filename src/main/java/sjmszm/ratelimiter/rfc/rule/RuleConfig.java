package sjmszm.ratelimiter.rfc.rule;

import java.util.List;

public class RuleConfig {

    private List<AppRuleConfig> configs;

    public List<AppRuleConfig> getConfigs() {
        return configs;
    }

    public void setConfigs(List<AppRuleConfig> configs) {
        this.configs = configs;
    }

    public static class AppRuleConfig {

        private String appId;

        private List<AppLimit> limits;

        public List<AppLimit> getLimits() {
            return limits;
        }

        public void setLimits(List<AppLimit> limits) {
            this.limits = limits;
        }

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }
    }
}
