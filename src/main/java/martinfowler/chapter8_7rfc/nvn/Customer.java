package martinfowler.chapter8_7rfc.nvn;

import java.util.HashSet;
import java.util.Set;

public class Customer {

    private Set<Order> orders = new HashSet<>();

    Set<Order> friendOrders() {
        return this.orders;
    }

    void addOrder(Order arg) {
        arg.addCustomer(this);
    }

    void removeOrder(Order arg) {
        arg.removeCustomer(this);
    }

}
