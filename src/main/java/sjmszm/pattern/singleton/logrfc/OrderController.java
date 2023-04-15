package sjmszm.pattern.singleton.logrfc;

public class OrderController {

    Logger logger = new Logger();

    public void create(OrderVo order) {
        Logger.getInstance().log("Created an order: " + order.toString());
    }

}
