package sjmszm.pattern.proxy.controllerrfc2;

import sjmszm.pattern.proxy.UserVo;

public interface IUserController {

    UserVo login(String telephone, String password);

    UserVo register(String telephone, String password);

}
