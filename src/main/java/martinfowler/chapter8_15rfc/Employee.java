package martinfowler.chapter8_15rfc;

public class Employee {

//    static final int ENGINEER = 0;
//    static final int SALESMAN = 1;
//    static final int MANAGER = 2;
    // 8. 删除掉类型码定义，代之以一个指向 EmployeeType对象的引用
//    public int type;
    private EmployeeType _type;

//    public Employee(int arg) {
//        this.type = arg;
//    }

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
    // 9.运用Replace Conditional With Polymorphism处理payAmount()函数
    // 9.1 将payAmount移动到EmployeeType类，因为他才是被集成的类
    // 9.2 由于我使用类Employee的数据：monthlySalary，commission，bonus，所以我将Employee作为参数传递给payAmount
//    public int payAmount() {
//        switch (getType()) {
//            case EmployeeType.ENGINEER:
//                return monthlySalary;
//            case EmployeeType.SALESMAN:
//                return monthlySalary + commission;
//            case EmployeeType.MANAGER:
//                return monthlySalary + bonus;
//            default:
//                throw new RuntimeException("Incorrect Employee Code");
//        }
//    }
    public int payAmount() {
        return _type.payAmount(this);
    }

    //1.类型码自封装
    //4.修改类型码访问函数setType,getType
    int getType() {
        return _type.getTypeCode();
    }

    //5.运行Replace Constructor with Factory Method针对不同的case子句建立相应的工厂函数，
    //6.将所有关于类型码和子类的知识移动到新类中EmployeeType
//    public static EmployeeType newType(int type) {
//        switch (type) {
//            case ENGINEER:
//                return new Engineer();
//            case SALESMAN:
//                return new Salesman();
//            case MANAGER:
//                return new Manager();
//            default:
//                throw new RuntimeException("Incorrect Employee Code");
//        }
//    }

    // 7. 调整类型码的赋值语句
    void setType(int type) {
        _type = EmployeeType.newType(type);
//        switch (type) {
//            case ENGINEER:
//                _type = new Engineer();
//            case SALESMAN:
//                _type = new Salesman();
//            case MANAGER:
//                _type = new Manager();
//            default:
//                throw new RuntimeException("Incorrect Employee Code");
//        }
    }
}
