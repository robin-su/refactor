package martinfowler.chapter11_6rfc;

abstract class JobItem {

    private int quantity;
    // 13.只有按照零件收费的工作才会用到unitPrice字段，再次运行Extract SubClass
//    private int unitPrice;
    //9.由于特性下移，这里需要声明为protected
//    private Employee employee;
    //11.isLabor字段传达的信息，现在已经成为继承体系内在信息，因此可以移除这个字段。最好的方式
    //是使用Self Encapsulate Field，然后在修改访问函数，该用多态常量函数-- 这样在不同的子类
//  实现版本中返回不同的固定值
    //11.1
//    private boolean isLabor;
    //11.2
    protected boolean isLabor() {
        return false;
    }

    //4.创建一个新构造函数，并把旧构造函数申明为protected
//    public JobItem(int quantity, int unitPrice) {
////        this(quantity,unitPrice,false,null);
//        //10.2
//        this(quantity,unitPrice);
//    }
    //10.再次清理构造器，让employee字段只在即将去达的子类中被初始化
//    protected JobItem(int quantity, int unitPrice, boolean isLabor,Employee employee) {
//        this.quantity = quantity;
//        this.unitPrice = unitPrice;
//        this.employee = employee;
//        this.isLabor = isLabor;
//    }
    //10.1
    protected JobItem(int quantity) {
        this.quantity = quantity;
//        this.unitPrice = unitPrice;
        //11.2
//        this.isLabor = isLabor;
    }

    public int getTotalPrice() {
        return quantity * getUnitPrice();
    }

    //12.使用Replace Conditional with Polymorphism重构他们
//    public int getUnitPrice() {
//        //12.1
////        return (isLabor()) ?  // 按工时收费
////                employee.getRate() :
////                unitPrice;
//        return unitPrice;
//    }

    abstract int getUnitPrice();

    public int getQuantity() {
        return quantity;
    }

//    public Employee getEmployee() {
//        return employee;
//    }
}
