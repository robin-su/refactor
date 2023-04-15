package martinfowler.chapter8_15;

public class Employee {

    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;

    public int type;

    public Employee(int arg) {
        this.type = arg;
    }

    public int monthlySalary;
    public int commission;
    public int bonus;

    /**
     * 类型码影响了类的行为，但是
     * 1） 类型码值在对象创建之后没有变
     * 2） 类型码的宿主类没有子类
     * 因此使用 replace-type-code-with-subclasses
     * 否则： 使用Replace Type Code With State/Strategy
     * 如果类型码不会影响类的行为：则使用Replace Type Code with Class
     *
     * 注意：这里假设可以将表现出色的工程师晋升为经理，也就是说对象的类型码是可变的。符合1）
     * 类型码在对象的生命周期内发生了变化，因此需要使用Replace Type Code With State/Strategy
     *
     * @return
     */
    public int payAmount() {
        switch (type) {
            case ENGINEER:
                return monthlySalary;
            case SALESMAN:
                return monthlySalary + commission;
            case MANAGER:
                return monthlySalary + bonus;
            default:
                throw new RuntimeException("Incorrect Employee Code");
        }
    }
}
