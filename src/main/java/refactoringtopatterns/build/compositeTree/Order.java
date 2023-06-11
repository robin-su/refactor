package refactoringtopatterns.build.compositeTree;

import java.util.List;

public class Order {

    private int orderId;

    private List<Product> products;

    public int getOrderId() {
        return orderId;
    }

    public int getProductCount() {
        return products.size();
    }

    public Product getProduct(int i) {
        return products.get(i);
    }

}
