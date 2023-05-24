package sjmszm.ratelimiter.mvp.rule;

import java.util.List;

public class AppRuleConfig {

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
