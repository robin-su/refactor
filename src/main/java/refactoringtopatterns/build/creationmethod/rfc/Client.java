package refactoringtopatterns.build.creationmethod.rfc;

import refactoringtopatterns.build.creationmethod.CapitalStrategy;
import refactoringtopatterns.build.creationmethod.CapitalStrategyTermLoan;

import java.util.Date;

public class Client {

    private static void testTermLoanNoPayments() {
        double commitment = 0.0;
        int riskRating = 5;
        Date maturity = new Date();
        Loan.createTermLoan(commitment, riskRating, maturity);
    }

    private static void testTermLoanWithRiskAdjusted() {
        CapitalStrategy riskAdjustedCapitalStrategy = new CapitalStrategyTermLoan();
        double commitment = 0.0;
        double outstanding = 0.0;
        int riskRating = 5;
        Date maturity = new Date();
        Loan loan = Loan.createTermLoan(riskAdjustedCapitalStrategy, commitment, outstanding, riskRating, maturity);
    }

}
