package refactoringtopatterns.build.compositeTree;

import java.util.List;

public class Orders {

    private List<Order> orders;

    public Orders(List<Order> orders) {
        this.orders = orders;
    }

    public int getOrderCount() {
        return orders.size();
    }

    public Order getOrder(int i) {
        return orders.get(i);
    }







}
