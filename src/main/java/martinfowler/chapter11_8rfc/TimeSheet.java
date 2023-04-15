package martinfowler.chapter11_8rfc;

public class TimeSheet {

    public double charge(Billable emp, int days) {
        double base = emp.getRate() * days;
        if(emp.hasSpecialSkill()) {
            return base * 1.05;
        } else {
            return base;
        }
    }

}
