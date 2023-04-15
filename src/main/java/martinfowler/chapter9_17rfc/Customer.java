package martinfowler.chapter9_17rfc;

//4.让源类实现Nullable空对象接口
class Customer implements Nullable{

    String _name;
    BillingPlan _billingPlan;
    PaymentHistory _paymentHistory;

    @Override
    public boolean isNull() {
        return false;
    }

    //5.添加工厂函数，专门用来创建NullCustomer对象
    static Customer newNull() {
        return new NullCustomer();
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
