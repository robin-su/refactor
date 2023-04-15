package martinfowler.chapter8_14rfc;

public class Manager extends Employee{
    @Override
    int getType() {
        return Employee.MANAGER;
    }
}
