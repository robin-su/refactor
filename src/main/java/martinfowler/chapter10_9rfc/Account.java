package martinfowler.chapter10_9rfc;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

class Account {

    private Vector transactions = new Vector();

    //2.针对使用该组参数的所有函数，实施Add Parameter,传入上述新建的类的实例对象，并将此参数设置为null,目的是找出那些调用的客户端
//    public double getFlowBetween(Date start, Date end) {
    //3.将Data Clumps中的每一项，从函数签名中移除之，并修改调用段和函数本体，令他们都改而通过新的参数对象取得该值
//    public double getFlowBetween(Date start, Date end,DataRange range) {
    //4.运行Extract Method
    public double getFlowBetween(DataRange range) {
        double result = 0.0;
        Enumeration e = transactions.elements();
        while (e.hasMoreElements()) {
            Transaction each = (Transaction)e.nextElement();
//           if (each.getDate ().compareTo(range.getStartDate()) >= 0 && each.getDate().compareTo(range.getEndDate()) <= 0) {
            if(range.includes(each.getDate())) {
                result += each.getValue();
            }
        }
        return result;
    }
}
