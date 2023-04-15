package martinfowler.chapter01;

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
    public String statement() {
        double totalAmount = 0;
        //常客计算积分时使用
        int frequentRenterPoints = 0;
        Enumeration enumeration = rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (enumeration.hasMoreElements()) {
            //总金额
            double thisAmount = 0;
            Rental each = (Rental) rentals.elements();
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    //优惠力度
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    //果然还是新书最贵啊
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }
            frequentRenterPoints++;
            //如果是新书，另算积分呢
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() >= 1) {
                frequentRenterPoints++;
            }
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
