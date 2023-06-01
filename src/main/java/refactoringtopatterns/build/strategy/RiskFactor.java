package refactoringtopatterns.build.strategy;

public class RiskFactor {

    public static RiskFactor getFactors() {
        return new RiskFactor();
    }

    public double forRating(int riskRating) {
        return 1;
    }

}
