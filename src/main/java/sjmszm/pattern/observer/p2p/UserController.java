package sjmszm.pattern.observer.p2p;

public class UserController {

    private UserService userService;//依赖注入
    private PromotionService promotionService; //依赖注入

    public long register(String telephone,String password) {
        //省略输入参数的校验代码
        // 省略userService.register()异常的try-catch代码
        long userId = userService.register(telephone, password); // 注册
        promotionService.issueNewUserExperienceCash(userId); // 发放体验金
        return userId;
    }

}
