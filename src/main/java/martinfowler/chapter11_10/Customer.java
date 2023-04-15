package martinfowler.chapter11_10;

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
        Enumeration enumeration = rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (enumeration.hasMoreElements()) {
            Rental each = (Rental) rentals.elements();
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        Enumeration enumeration = rentals.elements();
        String result = "<H1>Rentals for<EM>" + getName() + "</EM></H1><P>\n";
        while(enumeration.hasMoreElements()) {
            Rental each = (Rental)enumeration.nextElement();
            result += each.getMovie().getTitle() +": " + String.valueOf(getTotalCharge()) +"<BR>\n";
        }
        result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) +"</EM><P>\n";
        result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration enumeration = rentals.elements();
        while (enumeration.hasMoreElements()) {
            Rental each = (Rental) rentals.elements();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration enumeration = rentals.elements();
        while (enumeration.hasMoreElements()) {
            Rental each = (Rental) rentals.elements();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

}
