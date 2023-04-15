package martinfowler.chapter10_9;

import java.util.Date;

class Transaction {
    private Date chargeDate;
    private double value;

    public Transaction(Date chargeDate, double value) {
        this.chargeDate = chargeDate;
        this.value = value;
    }

    public Date getDate() {
        return chargeDate;
    }

    public double getValue() {
        return value;
    }
}
