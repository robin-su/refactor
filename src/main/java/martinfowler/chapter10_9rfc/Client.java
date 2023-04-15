package martinfowler.chapter10_9rfc;

import java.util.Date;

public class Client {

    public static void main(String[] args) {
        Account account = new Account();
//        account.getFlowBetween(new Date(), new Date());
        double flow = account.getFlowBetween(new DataRange(new Date(), new Date()));

    }

}
