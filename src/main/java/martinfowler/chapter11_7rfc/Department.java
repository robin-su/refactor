package martinfowler.chapter11_7rfc;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

class Department extends Party {

    private String name;
    private Vector staff = new Vector();

    public Department(String name) {
        super(name);
    }
    //5.Department#getTotalAnnualCost() 和Employee.getAnnualCost()两个方法具有相同的名称
    //因此，将其修改成相同的名字Rename Method
//    public int getTotalAnnualCost() {
    public int getAnnualCost() {
        int result = 0;
        Iterator iter = staff.iterator();
        while (iter.hasNext()) {
            Employee each = (Employee)iter.next();
            result += each.getAnnualCost();
        }
        return result;
    }

    public int getHeadCount() {
        return staff.size();
    }

    public Enumeration getStaff() {
        return staff.elements();
    }

    public void addStaff(Employee arg) {
        staff.add(arg);
    }

    public String getName() {
        return name;
    }
}
