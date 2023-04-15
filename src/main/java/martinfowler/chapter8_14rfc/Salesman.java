package martinfowler.chapter8_14rfc;

public class Salesman extends Employee{
    @Override
    int getType() {
        return Employee.SALESMAN;
    }
}
