package refactoringtopatterns.build.template;

public class CapitalStrategyAdvisedLine extends CapitalStrategy {

    @Override
    public double capital(Loan loan) {
        return loan.getCommitment() * loan.getUnusedPercentage() * duration(loan) * riskFactor(loan);
    }

}
