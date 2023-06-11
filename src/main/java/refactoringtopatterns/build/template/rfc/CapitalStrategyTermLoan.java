package refactoringtopatterns.build.template.rfc;

public class CapitalStrategyTermLoan extends CapitalStrategy {

    public double capital(Loan loan) {
        return riskAmountFor(loan) * duration(loan) * riskFactor(loan);
    }

    public double riskAmountFor(Loan loan) {
        return loan.getCommitment();
    }

    public double duration(Loan loan) {
        return weightedAverageDuration();
    }

    private double weightedAverageDuration() {
        return 1;
    }

}
