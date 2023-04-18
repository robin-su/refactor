package sjmszm.pattern.proxy.controllerrfc3;


public class Client {


    public static void main(String[] args) {
//        UserControllerProxy userController = new UserControllerProxy(new UserController());
//        UserControllerProxy userControllerProxy = new UserControllerProxy();
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserController userController = (IUserController)proxy.createProxy(new UserController());
    }

}
