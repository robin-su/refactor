package refactoringtopatterns.build.creationmethod;

import java.util.Date;

public class Client {

    private static void testTermLoanNoPayments() {
        double commitment = 0.0;
        int riskRating = 5;
        Date maturity = new Date();
        Loan loan = new Loan(commitment, riskRating, maturity);
    }

    private static void testTermLoanWithRiskAdjusted() {
        CapitalStrategy riskAdjustedCapitalStrategy = new CapitalStrategyTermLoan();
        double commitment = 0.0;
        double outstanding = 0.0;
        int riskRating = 5;
        Date maturity = new Date();
        Loan loan = new Loan(riskAdjustedCapitalStrategy,commitment,outstanding,riskRating,maturity,null);
    }

}
