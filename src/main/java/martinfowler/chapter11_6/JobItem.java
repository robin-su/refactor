package martinfowler.chapter11_6;

class JobItem {

    private int quantity;
    private int unitPrice;
    private Employee employee;
    private boolean isLabor;

    public JobItem(int quantity, int unitPrice,boolean isLabor,Employee employee) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.employee = employee;
        this.isLabor = isLabor;
    }

    public int getTotalPrice() {
        return quantity * getUnitPrice();
    }

    public int getUnitPrice() {
        return (isLabor) ?  // 按工时收费
                employee.getRate() :
                unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public Employee getEmployee() {
        return employee;
    }
}
