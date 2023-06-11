package refactoringtopatterns.build.template.rfc;

public class CapitalStrategyAdvisedLine extends CapitalStrategy {

    @Override
    public double capital(Loan loan) {
        return riskAmountFor(loan) * duration(loan) * riskFactor(loan);

    }

    public double riskAmountFor(Loan loan) {
        return loan.getCommitment() * loan.getUnusedPercentage();
    }
}
