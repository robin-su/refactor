package sjmszm.pattern.proxy.controllerrfc;

import sjmszm.pattern.proxy.controller.UserController;

public class Client {


    public static void main(String[] args) {
        UserControllerProxy userController = new UserControllerProxy(new UserController());

    }

}
