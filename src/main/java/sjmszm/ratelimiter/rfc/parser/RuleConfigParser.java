package sjmszm.ratelimiter.rfc.parser;

import sjmszm.ratelimiter.rfc.rule.RuleConfig;

import java.io.InputStream;

public interface RuleConfigParser {

    RuleConfig parse(InputStream in);

}
