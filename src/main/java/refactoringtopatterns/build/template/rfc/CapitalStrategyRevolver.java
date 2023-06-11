package refactoringtopatterns.build.template.rfc;

public class CapitalStrategyRevolver extends CapitalStrategy {

    @Override
    public double capital(Loan loan) {
        return  super.capital(loan)
                + (loan.unusedRiskAmount() * duration(loan) * this.unusedRiskFactor(loan));
    }

    @Override
    public double riskAmountFor(Loan loan) {
        return loan.outstandingRiskAmount();
    }
}
