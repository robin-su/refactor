package refactoringtopatterns.build.strategy.rfc;


import java.util.Date;

public class Loan {

    private double commitment;
    private double outstanding;
    private Date expiry;
    private Date maturity;
    private int riskRating;

    private Date today;
    private Date start;

    private CapitalStrategy capitalStrategy;

    public static Loan newTermLoan(double commitment, Date start, Date maturity,int riskRating) {
        return new Loan(commitment, commitment,start,null,maturity,riskRating,new CapitalStrategyTermLoan());
    }

    public static Loan newRevolver(double commitment, Date start, Date expiry,int riskRating) {
        return new Loan(commitment, 0, start, expiry,null,riskRating,new CapitalStrategyRevolver());
    }

    public static Loan newAdvisedLine(double commitment, Date start, Date expiry,int riskRating) {
        return new Loan(commitment,0,start,expiry,null,riskRating,new CapitalStrategyAdvisedLine());
    }

    public Loan(double commitment, double outstanding, Date start, Date expiry, Date maturity, int riskRating,CapitalStrategy capitalStrategy) {
        this.commitment = commitment;
        this.outstanding = outstanding;
        this.expiry = expiry;
        this.maturity = maturity;
        this.riskRating = riskRating;
        this.start = start;
        this.today = new Date();

        // 重构方法中多次new了CapitalStrategy
        this.capitalStrategy = capitalStrategy;
    }


    /**
     * 1.移动方法和所需属性至CapitalStrategy【属性和方法】
     * 修改方法调用为委托CapitalStrategy
     * @return
     */
    public double capital() {
        return this.capitalStrategy.capital(this);
    }

    public double duration() {
        return this.capitalStrategy.duration(this);
    }

    public double getUnusedPercentage() {
        return 1.0;
    }

    private double weightedAverageDuration() {
        return 1;
    }

    /**
     * 未用风险金额
     */
    protected double unusedRiskAmount() {
        return this.commitment - this.outstanding;
    }

    /**
     * 未清风险金额
     */
    protected double outstandingRiskAmount() {
        return this.outstanding;
    }

    /**
     * 添加getter方法，让策略可见，注意方法的权限应该改为包权限
     *
     * @return
     */
    protected double getCommitment() {
        return commitment;
    }

    protected double getOutstanding() {
        return outstanding;
    }

    protected Date getExpiry() {
        return expiry;
    }

    protected Date getMaturity() {
        return maturity;
    }

    protected int getRiskRating() {
        return riskRating;
    }

    protected Date getToday() {
        return today;
    }

    protected Date getStart() {
        return start;
    }
}
