package martinfowler.chapter10_9;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

class Account {

    private Vector transactions = new Vector();

    public double getFlowBetween(Date start, Date end) {
        double result = 0.0;
        Enumeration e = transactions.elements();
        while (e.hasMoreElements()) {
            Transaction each = (Transaction)e.nextElement();
            if (each.getDate().compareTo(start) >= 0 && each.getDate().compareTo(end) <= 0) {
                result += each.getValue();
            }
        }
        return result;
    }
}
