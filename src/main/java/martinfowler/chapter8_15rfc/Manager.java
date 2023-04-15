package martinfowler.chapter8_15rfc;

public class Manager extends EmployeeType{
    @Override
    int getTypeCode() {
        return EmployeeType.MANAGER;
    }

    @Override
    public int payAmount(Employee employee) {
        return employee.monthlySalary + employee.bonus;
    }
}
