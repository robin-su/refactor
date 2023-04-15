package sjmszm.pattern.singleton.logrfc;

import java.io.IOException;

public class UserController {

    public void log(String username, String password) throws IOException {
        Logger.getInstance().log(username + " logined!");
    }

}
