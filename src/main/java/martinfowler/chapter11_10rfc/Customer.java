package martinfowler.chapter11_10rfc;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String name;
    //Vector 类实现了一个动态数组。和 ArrayList 很相似，但是两者是不同的；
    //1.Vector 是同步访问的。2.Vector 包含了许多传统的方法，这些方法不属于集合框架。
    //Vector 主要用在事先不知道数组的大小，或者只是需要一个可以改变大小的数组的情况。
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    /**
     * 提供一个用于生成详单的函数
     */

    //2. 通过Move Method，将两个负责输出报表的函数分别移动到对应的子类中
    public String statement() {
        //2.3
        return new TextStatement().value(this);
    }

    public String htmlStatement() {
        //2.4
        return new HtmlStatement().value(this);
    }

    protected Enumeration getRentals() {
        return ((Vector) rentals.clone()).elements();
    }

    protected double getTotalCharge() {
        double result = 0;
        Enumeration enumeration = rentals.elements();
        while (enumeration.hasMoreElements()) {
            Rental each = (Rental) rentals.elements();
            result += each.getCharge();
        }
        return result;
    }

    protected int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration enumeration = rentals.elements();
        while (enumeration.hasMoreElements()) {
            Rental each = (Rental) rentals.elements();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

}
