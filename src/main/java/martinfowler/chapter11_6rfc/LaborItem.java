package martinfowler.chapter11_6rfc;

/**
 * 1. 提炼出一个LaborItem子类，因为JobItem的某些行为和数据只在按工时收费时才需要，所以建立这样一个子类
 */
class LaborItem extends JobItem{

    private Employee employee;
    //2. 为LaborItem提供一个构造器，因为JobItem没有默认构造器，这里需要把超类构造函数的参数列表复制过来
    //7. 修改子类构造函数
    public LaborItem(int quantity, Employee employee) {
        //10.3
//        super(quantity, unitPrice, isLabor, employee);
        super(quantity);
        //10.4
        this.employee = employee;
    }

    // 8.将旧的JobItem的特性下移，先从函数开始运行Push Down Method
    public Employee getEmployee() {
        return employee;
    }

    //12.2
    @Override
    public int getUnitPrice() {
        return employee.getRate();
    }

    @Override
    protected boolean isLabor() {
        return true;
    }
}
