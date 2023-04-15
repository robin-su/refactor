package martinfowler.chapter9_17rfc;

class PaymentHistory {

    public boolean isNull() {
        return false;
    }

    //10.2 添加工厂函数，专门用来创建NullPaymentHistory对象
    static NullPaymentHistory newNull() {
        return new NullPaymentHistory();
    }


    public int weeksDelinquentInLastYear;

    public PaymentHistory() {
        weeksDelinquentInLastYear = 0;
    }

    public int getWeeksDelinquentInLastYear() {
        return weeksDelinquentInLastYear;
    }
}
