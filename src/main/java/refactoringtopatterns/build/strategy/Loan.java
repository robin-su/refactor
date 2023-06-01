package refactoringtopatterns.build.strategy;

import java.util.Date;

public class Loan {

    private double commitment;
    private double outstanding;
    private Date expiry;
    private Date maturity;
    private int riskRating;

    private Date today;
    private Date start;

    private static final int MILLIS_PER_DAY = 86400000;
    private static final int DAYS_PER_YEAR = 365;

    public Loan(double commitment, double outstanding, Date expiry, Date maturity, int riskRating, Date start) {
        this.commitment = commitment;
        this.outstanding = outstanding;
        this.expiry = expiry;
        this.maturity = maturity;
        this.riskRating = riskRating;
        this.start = start;
    }

    public double capital() {
        if(this.expiry == null && this.maturity != null) {
            return commitment * duration() * riskFactor();
        }
        if(this.expiry != null && maturity == null) {
            if(this.getUnusedPercentage() != 1) {
                return commitment * getUnusedPercentage() * duration() * riskFactor();
            } else {
                return (this.outstandingRiskAmount() * this.duration() * this.riskFactor())
                    + (this.unusedRiskAmount() * this.duration() * this.unusedRiskFactor());
            }
        }
        return 0.0;
    }

    public double getUnusedPercentage() {
        return 1.0;
    }

    private double riskFactor() {
        return RiskFactor.getFactors().forRating(riskRating);
    }

    private double unusedRiskFactor() {
        return UnusedRiskFactors.getFactors().forRating(riskRating);
    }

    public double duration() {
        if(this.expiry == null && this.maturity != null) {
            return weightedAverageDuration();
        } else if(this.expiry != null && this.maturity == null) {
            return this.yearsTo(this.expiry);
        }
        return 0.0;
    }

    public double yearsTo(Date endDate) {
        Date beginDate = (today == null ? this.start : this.today);
        return ((endDate.getTime() - beginDate.getTime()) / MILLIS_PER_DAY)/DAYS_PER_YEAR;
    }

    private double weightedAverageDuration() {
        return 1;
    }

    /**
     * 未用风险金额
     */
    private double unusedRiskAmount() {
        return this.commitment - this.outstanding;
    }

    /**
     * 未清风险金额
     */
    private double outstandingRiskAmount() {
        return this.outstanding;
    }
}
