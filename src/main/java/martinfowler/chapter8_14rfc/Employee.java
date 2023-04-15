package martinfowler.chapter8_14rfc;

public abstract class Employee {

    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;

    public int type;

    //2.由于类型码被传递给了构造器，所以将构造器变成工厂函数
//    public Employee(int arg) {
//        this.type = arg;
//    }

    // 4.修改工厂函数，令他返回一个合适的对象，
    // 5.逐一处理其他类型码，知道所有的类型码被替换成子类为止
    static Employee create(int type) {
        // 这里只用到了一处switch,并且只用于决定创建何种对象，这样的switch语句是可以接受的
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

    // 去掉该构造器
//    private Employee(int arg) {
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

    // 1.使用Self Encapsulate Field将类型码进行自我封装
//    int getType() {
//        return type;
//    }

    //6.修改getType为抽象函数
    abstract int getType();
}
