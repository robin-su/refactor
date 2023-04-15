package martinfowler.chapter8_7rfc.nvn;


import java.util.HashSet;
import java.util.Set;

/**
 * 多对多的时候，任意选择一个作为关联关系的控制者
 */
public class Order {

    private Set<Customer> customers = new HashSet<>();

    Set<Customer> friendCustomers() {
        return this.customers;
    }

    void addCustomer(Customer arg) {
        arg.friendOrders().add(this);
        customers.add(arg);
    }

    void removeCustomer(Customer arg) {
        arg.friendOrders().remove(this);
        customers.remove(arg);
    }



}
