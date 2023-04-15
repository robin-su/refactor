package martinfowler.chapter8_13rfc;

//1. 建立一个新的类表示血型
public class BloodGroup {

    //1.3 用一组静态变量保存允许被创建的实力
    public static final BloodGroup O = new BloodGroup(0);
    public static final BloodGroup A = new BloodGroup(1);
    public static final BloodGroup B = new BloodGroup(2);
    public static final BloodGroup AB = new BloodGroup(3);

    private static BloodGroup[] _value = {O , A, B, AB};

    private final int code;
    //1.1 私有化构造器
    private BloodGroup(int code) {
        this.code = code;
    }

    /**
     * 修改使用整形类型的函数声明为private，因为不在有别人使用他们
     */
    //1.2 添加取值函数
    private int getCode() {
        return code;
    }

    //1.4 以静态函数根据原本的类型码返回合适的实例 -> 本质是工厂函数
    private static BloodGroup code(int arg) {
        return _value[arg];
    }


}
