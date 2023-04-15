package martinfowler.chapter9_17rfc;

//10.1 同样的方式为PaymentHistory创建NullPaymentHistory
public class NullPaymentHistory extends PaymentHistory{

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public int getWeeksDelinquentInLastYear() {
        return 0;
    }

}
