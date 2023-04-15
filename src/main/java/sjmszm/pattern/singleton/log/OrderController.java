package sjmszm.pattern.singleton.log;

public class OrderController {

    Logger logger = new Logger();

    public void create(OrderVo order) {
        logger.log("Created an order: " + order.toString());
    }

}
