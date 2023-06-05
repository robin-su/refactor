package refactoringtopatterns.build.strategy.rfc;

public class CapitalStrategyTermLoan extends CapitalStrategy {

    public double capital(Loan loan) {
        return loan.getCommitment() * duration(loan) * riskFactor(loan);
    }

    public double duration(Loan loan) {
        return weightedAverageDuration();
    }

    private double weightedAverageDuration() {
        return 1;
    }

}
