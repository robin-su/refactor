package martinfowler.chapter11_10rfc;

import java.util.Enumeration;

//1.2
public class HtmlStatement extends Statement {

    //2.2
//    public String value(Customer aCustomer) {
//        Enumeration enumeration = aCustomer.getRentals();
//        String result = headerString(aCustomer);
//        while(enumeration.hasMoreElements()) {
//            Rental each = (Rental)enumeration.nextElement();
//            result += eachRentalString(each);
//        }
//        result = footerString(aCustomer, result);
//        return result;
//    }

    //3.6
    String footerString(Customer aCustomer, String result) {
        result += "<P>You owe <EM>" + String.valueOf(aCustomer.getTotalCharge())
                +"</EM><P>\n" +"On this rental you earned <EM>"
                + String.valueOf(aCustomer.getTotalFrequentRenterPoints())
                +"</EM> frequent renter points<P>";
        return result;
    }

    //3.4
    String eachRentalString(Rental each) {
        return each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
    }

    //3.2
    String headerString(Customer aCustomer) {
        return "<H1>Rentals for<EM>" + aCustomer.getName() + "</EM></H1><P>\n";
    }
}
