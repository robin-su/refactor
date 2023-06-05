package refactoringtopatterns.build.strategy.rfc;

public class CapitalStrategyRevolver extends CapitalStrategy {

    @Override
    public double capital(Loan loan) {
        return loan.getCommitment() * loan.getUnusedPercentage() * duration(loan) * riskFactor(loan);
    }
}
