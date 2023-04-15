package martinfowler.chapter10_6;

import java.util.ArrayList;
import java.util.List;

public class Order {

    public static final int FIXED_DISCOUNT = 0;
    public static final int PERCENT_DISCOUNT = 1;

    private double price;

    List<String> items = new ArrayList<>(6);

    public Order(double price) {
        this.price = price;
    }

    public void applyDiscount(int type, double discount) {
        switch (type) {
            case FIXED_DISCOUNT:
                price -= discount;
                break;
            case PERCENT_DISCOUNT:
                price *= discount;
                break;
            default:
                throw new IllegalArgumentException("Invalid discount type");
        }
    }


    public void applyFixedDiscount(double discount) {
        price -= discount;
    }

    public void applyPercentDiscount(double discount) {
        price *= discount;
    }

}
