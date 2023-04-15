package martinfowler.chapter8_15rfc;
//3.创造EmployeeType的子类
public class Engineer extends EmployeeType {
    @Override
    int getTypeCode() {
        return EmployeeType.ENGINEER;
    }

    @Override
    public int payAmount(Employee employee) {
        return employee.monthlySalary;
    }
}
