package sjmszm.openclosedprinciple;

import lombok.Data;

@Data
public class MatchedRule {

    private ApiRule[] rules;

    @Data
    public static class ApiRule {
        private String api;
        private long maxTps;
        private long maxErrorCount;
    }
}
