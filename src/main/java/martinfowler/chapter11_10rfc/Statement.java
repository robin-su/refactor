package martinfowler.chapter11_10rfc;

import java.util.Enumeration;

//1.建立一个集成体系，用于处理报表展示信息
// TextStatement extends Statement {}
// HtmlStatement extends Statement {}
abstract class Statement {

    //4.1
    public String value(Customer aCustomer) {
        Enumeration enumeration = aCustomer.getRentals();
        //3. 运行Extract Method将两个函数不同的部分提炼出来，从而将相似的代码和变动的代码分开
        String result = headerString(aCustomer);
        while (enumeration.hasMoreElements()) {
            Rental each = (Rental) enumeration.nextElement();
            result += eachRentalString(each);
        }
        result = footerString(aCustomer, result);
        return result;
    }

    //5.子类函数弄成抽象函数
    //5.1
    abstract String footerString(Customer aCustomer, String result) ;
    //5.2
    abstract String eachRentalString(Rental each);

    //5.3
    abstract String headerString(Customer aCustomer);
}
