package martinfowler.chapter9_17;

class Customer {

    String _name;
    BillingPlan _billingPlan;
    PaymentHistory _paymentHistory;

    public Customer(String name, BillingPlan billingPlan, PaymentHistory paymentHistory) {
        this._name = name;
        this._billingPlan = billingPlan;
        this._paymentHistory = paymentHistory;
    }

    public String getName() {
        return _name;
    }

    public BillingPlan getPlan() {
        return _billingPlan;
    }

    public PaymentHistory getHistory() {
        return _paymentHistory;
    }
}
