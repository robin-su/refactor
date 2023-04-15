package martinfowler.chapter8_15rfc;

//2.声明一个状态类，把它声明为一个抽象类，并提供一个抽象函数，用以返回类型码
public abstract class EmployeeType {

    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;

    abstract int getTypeCode();

    public static EmployeeType newType(int type) {
        switch (type) {
            case ENGINEER:
                return new Engineer();
            case SALESMAN:
                return new Salesman();
            case MANAGER:
                return new Manager();
            default:
                throw new RuntimeException("Incorrect Employee Code");
        }
    }

    //10.针对不同分支在不同的的子类，在其中加入payAmount方法
//    public int payAmount(Employee employee) {
//        switch (getTypeCode()) {
//            case ENGINEER:
//                return employee.monthlySalary;
//            case SALESMAN:
//                return employee.monthlySalary + employee.commission;
//            case MANAGER:
//                return employee.monthlySalary + employee.bonus;
//            default:
//                throw new RuntimeException("Incorrect Employee Code");
//        }
//    }
    // 11.抽象化payAmount
    public abstract int payAmount(Employee employee);

}
