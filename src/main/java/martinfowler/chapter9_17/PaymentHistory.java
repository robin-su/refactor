package martinfowler.chapter9_17;

class PaymentHistory {

    public int weeksDelinquentInLastYear;

    public PaymentHistory() {
        weeksDelinquentInLastYear = 0;
    }

    public int getWeeksDelinquentInLastYear() {
        return weeksDelinquentInLastYear;
    }
}
