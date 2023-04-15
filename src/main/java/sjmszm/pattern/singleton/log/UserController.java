package sjmszm.pattern.singleton.log;

import java.io.IOException;

public class UserController {

    Logger logger = new Logger();

    public void log(String username, String password) throws IOException {
        logger.log(username + " logined!");
    }

}
