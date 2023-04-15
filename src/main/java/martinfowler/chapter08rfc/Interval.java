package martinfowler.chapter08rfc;

import java.util.Observable;

/**
 * 1.建立一个领域类
 *
 * Interval是一个领域类
 *
 */
public class Interval extends Observable {
    /**
     * 8.GUI数据赋予初值。并增加getXxx和setXxx方法
     * 9.setXxx设置函数必须发出通告
     */
    private String end = "0";
    private String start = "0";
    private String length = "0";

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
        setChanged();
        notifyObservers();
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
        setChanged();
        notifyObservers();
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
        setChanged();
        notifyObservers();
    }

    // 10.将calculateLength() 和calculateEnd() 搬移到Interval对象中
    void calculateLength() {
        try {
            int start = Integer.parseInt(getStart());
            int end = Integer.parseInt(getEnd());
            int length = end - start;
            setLength(String.valueOf(length));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Unexcepted Number Format Error:%s");
        }
    }

    void calculateEnd() {
        try {
            int start = Integer.parseInt(getStart());
            int length = Integer.parseInt(getLength());
            int end = start + length;
            setEnd(String.valueOf(end));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Unexcepted Number Format Error:%s");
        }
    }



}
