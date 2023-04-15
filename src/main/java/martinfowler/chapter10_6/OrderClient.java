package martinfowler.chapter10_6;

public class OrderClient {

    private static boolean weekend = true;

    public static void main(String[] args) {
        Order order = new Order(10.0);
        if (weekend) {
//            order.applyDiscount(Order.FIXED_DISCOUNT,10);
            order.applyFixedDiscount(10);
        }
        if (order.items.size() > 5) {
//            order.applyDiscount(Order.PERCENT_DISCOUNT,0.2);
            order.applyPercentDiscount(0.2);
        }
    }

}
