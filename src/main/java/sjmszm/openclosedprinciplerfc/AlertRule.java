package sjmszm.openclosedprinciplerfc;

import java.util.stream.Stream;

class AlertRule {

    private MatchedRule matchedRule;

    public AlertRule(MatchedRule matchedRule) {
        this.matchedRule = matchedRule;
    }

    public MatchedRule.ApiRule getMatchedRule(String api) {
        return Stream.of(matchedRule.getRules())
                .filter(s -> s.getApi().equals(api))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(String.format("Not found the api: %s",api))
                );
    }
}
