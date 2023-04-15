package martinfowler.chapter8_15rfc;

public class Salesman extends EmployeeType{
    @Override
    int getTypeCode() {
        return EmployeeType.SALESMAN;
    }

    @Override
    public int payAmount(Employee employee) {
        return employee.monthlySalary + employee.commission;
    }
}
