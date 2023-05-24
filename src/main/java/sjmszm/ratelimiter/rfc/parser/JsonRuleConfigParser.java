package sjmszm.ratelimiter.rfc.parser;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import sjmszm.ratelimiter.mvp.exception.ConfigurationResolveException;
import sjmszm.ratelimiter.rfc.rule.RuleConfig;

import java.io.InputStream;

public class JsonRuleConfigParser implements RuleConfigParser {

    /**
     * 如果 func1() 抛出的异常太底层，对 func2() 的调用方来说，缺乏背景去理解、且业务概念上无关，
     * 我们可以将它重新包装成调用方可以理解的新异常，然后 re-throw。
     *
     * @param in
     * @return
     */
    @Override
    public RuleConfig parse(InputStream in) {
        if(in == null) {
            return null;
        }
        ObjectMapper objectMapper =
                new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            return objectMapper.readValue(in,RuleConfig.class);
        } catch (Exception e) {
            throw new ConfigurationResolveException("parse json failed.",e);
        }
    }
}
