package sjmszm.ratelimiter.rfc.datasource;

import sjmszm.ratelimiter.rfc.rule.RuleConfig;

public interface RuleConfigSource {

    RuleConfig load();
}
