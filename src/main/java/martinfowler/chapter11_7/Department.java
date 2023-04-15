package martinfowler.chapter11_7;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

class Department {

    private String name;
    private Vector staff = new Vector();

    public Department(String name) {
        this.name = name;
    }

    public int getTotalAnnualCost() {
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
