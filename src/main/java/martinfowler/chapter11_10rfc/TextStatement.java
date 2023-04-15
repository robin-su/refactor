package martinfowler.chapter11_10rfc;

import java.util.Enumeration;

//1.1
class TextStatement extends Statement {

    //2.1
    //4.TextStatement#value和HtmlStatement#value已经非常相似了，可以运行Pull Up Method,将其搬运到超类中
//    public String value(Customer aCustomer) {
//        Enumeration enumeration = aCustomer.getRentals();
//        //3. 运行Extract Method将两个函数不同的部分提炼出来，从而将相似的代码和变动的代码分开
//        String result = headerString(aCustomer);
//        while (enumeration.hasMoreElements()) {
//            Rental each = (Rental) enumeration.nextElement();
//            result += eachRentalString(each);
//        }
//        result = footerString(aCustomer, result);
//        return result;
//    }

    //3.5
    String footerString(Customer aCustomer, String result) {
        result += "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n"
                + "You earned " + String.valueOf(aCustomer.getTotalFrequentRenterPoints())
                + " frequent renter points";
        return result;
    }

    //3.3
    String eachRentalString(Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
    }

    //3.1
    String headerString(Customer aCustomer) {
        return "Rental Record for " + aCustomer.getName() + "\n";
    }

}
