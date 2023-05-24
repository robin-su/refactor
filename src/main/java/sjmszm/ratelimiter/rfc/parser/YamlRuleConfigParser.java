package sjmszm.ratelimiter.rfc.parser;

import org.yaml.snakeyaml.Yaml;
import sjmszm.ratelimiter.mvp.exception.ConfigurationResolveException;
import sjmszm.ratelimiter.rfc.rule.RuleConfig;

import java.io.InputStream;

public class YamlRuleConfigParser implements RuleConfigParser {

    @Override
    public RuleConfig parse(InputStream in) {
        if(in == null) {
            return null;
        }
        Yaml yaml = new Yaml();
        try {
            return yaml.loadAs(in, RuleConfig.class);
        } catch (Exception e) {
            throw new ConfigurationResolveException("parse yaml failed",e);
        }
    }
}
