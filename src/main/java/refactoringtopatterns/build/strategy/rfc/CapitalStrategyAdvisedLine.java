package refactoringtopatterns.build.strategy.rfc;

public class CapitalStrategyAdvisedLine extends CapitalStrategy {

    @Override
    public double capital(Loan loan) {
        return  (loan.outstandingRiskAmount() * duration(loan) * this.riskFactor(loan))
                + (loan.unusedRiskAmount() * duration(loan) * this.unusedRiskFactor(loan));
    }
}
