package refactoringtopatterns.build.strategy;

public class UnusedRiskFactors {

    public static UnusedRiskFactors getFactors() {
        return new UnusedRiskFactors();
    }

    public double forRating(int riskRating) {
        return 1;
    }
}
