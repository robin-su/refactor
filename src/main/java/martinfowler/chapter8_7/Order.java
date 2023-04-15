package martinfowler.chapter8_7;

public class Order {
    // Order中持有Customer的单个引用，所以Order作为关联关系的控制端
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
