package refactoringtopatterns.build.template;

import java.util.Date;

public abstract class CapitalStrategy {

    private static final int MILLIS_PER_DAY = 86400000;
    private static final int DAYS_PER_YEAR = 365;

    public abstract double capital(Loan loan);

    protected double riskFactor(Loan loan) {
        return RiskFactor.getFactors().forRating(loan.getRiskRating());
    }

    protected double unusedRiskFactor(Loan loan) {
        return UnusedRiskFactors.getFactors().forRating(loan.getRiskRating());
    }

    public double duration(Loan loan) {
        return this.yearsTo(loan.getExpiry(),loan);
    }

    public double yearsTo(Date endDate, Loan loan) {
        Date beginDate = (loan.getToday() == null ? loan.getStart() : loan.getToday());
        return ((endDate.getTime() - beginDate.getTime()) / MILLIS_PER_DAY)/DAYS_PER_YEAR;
    }



}
