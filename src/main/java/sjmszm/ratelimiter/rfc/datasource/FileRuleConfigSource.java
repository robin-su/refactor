package sjmszm.ratelimiter.rfc.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sjmszm.ratelimiter.rfc.parser.JsonRuleConfigParser;
import sjmszm.ratelimiter.rfc.parser.RuleConfigParser;
import sjmszm.ratelimiter.rfc.parser.YamlRuleConfigParser;
import sjmszm.ratelimiter.rfc.rule.RuleConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于本地文件的配置类
 */
public class FileRuleConfigSource implements RuleConfigSource {
    private static final Logger logger = LoggerFactory.getLogger(FileRuleConfigSource.class);

    public static final String API_LIMIT_CONFIG_NAME = "ratelimiter-rule";
    public static final String JSON_EXTENSION = "json";
    public static final String YML_EXTENSION = "yml";
    public static final String YAML_EXTENSION = "yaml";

    private static final String[] SUPPORT_EXTENSIONS = new String[] {
            JSON_EXTENSION,
            YML_EXTENSION,
            YAML_EXTENSION
    };

    private static final Map<String,RuleConfigParser> PARSER_MAP = new HashMap<>();

    static {
        PARSER_MAP.put(YAML_EXTENSION, new YamlRuleConfigParser());
        PARSER_MAP.put(YML_EXTENSION, new YamlRuleConfigParser());
        PARSER_MAP.put(JSON_EXTENSION, new JsonRuleConfigParser());
    }


    /**
     * 思考一：这个方法的两个问题
     * 1） 没有可拓展性，因为限定了YAML格式
     * 2） 限定死了读取路径
     * @return
     */
    @Override
    public RuleConfig load() {
        for (String extension : SUPPORT_EXTENSIONS) {
            // 将限流规则配置文件ratelimiter-rule.yaml中的内容读取到RuleConfig中
            InputStream in = null;
            try {
                in = this.getClass().getResourceAsStream("/" + getFileNameByExt(extension));
                if(in != null) {
                    RuleConfigParser parser = new YamlRuleConfigParser();
                    return parser.parse(in);
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
        }
        return null;
    }

//    /**
//     * 1.限定了YAML
//     *
//     * @param in
//     * @return
//     */
//    private RuleConfig parse(InputStream in) {
//        Yaml yaml = new Yaml();
//        RuleConfig ruleConfig = yaml.loadAs(in, RuleConfig.class);
//        return ruleConfig;
//    }

    private String getFileNameByExt(String extension) {
        return API_LIMIT_CONFIG_NAME + "." + extension;
    }
}
