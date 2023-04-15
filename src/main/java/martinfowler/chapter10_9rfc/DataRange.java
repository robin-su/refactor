package martinfowler.chapter10_9rfc;

import java.util.Date;

/**
 * 1.新建一个类,用以替换你想替换的一组参数，并将这个类设置成不可变的
 */
public class DataRange {

    private final Date startDate;
    private final Date endDate;

    public DataRange(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean includes(Date arg) {
        return arg.compareTo(startDate) >= 0 && arg.compareTo(endDate) <= 0;
    }
}
