package sjmszm.pattern.proxy.controllerrfc;

import sjmszm.pattern.proxy.UserVo;

public interface IUserController {

    UserVo login(String telephone, String password);

    UserVo register(String telephone, String password);

}
