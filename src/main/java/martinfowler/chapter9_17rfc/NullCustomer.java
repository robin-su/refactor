package martinfowler.chapter9_17rfc;

/**
 * 1.为源类建立一个子类，使其行为就像是源类的null版本。
 * 2.在源类和null子类中都加上isNull()函数，源类isNull()返回false，子类isNull返回true
 */
public class NullCustomer extends Customer {
    @Override
    public boolean isNull() {
        return true;
    }
    //8.1 在null子类中覆盖A动作，使其行为和B动作相同
    @Override
    public String getName() {
        return "occupant";
    }

    @Override
    public BillingPlan getPlan(){
        return BillingPlan.basic();
    }

    //11. 添加getHistory让他返回NullPaymentHistory
    @Override
    public PaymentHistory getHistory() {
        return PaymentHistory.newNull();
    }
}
