package sjmszm.pattern.singleton.parameters;

//最推荐的方案，可以从配置文件中加载得到

/**
 * 单例本来就推荐用无参构造函数，要更新成员变量的值，写个update函数嘛
 */
public class Singleton3 {

    private static Singleton3 instance = null;
    private final int paramA;
    private final int paramB;

    private Singleton3() {
        this.paramA = Config.PARAM_A;
        this.paramB = Config.PARAM_B;
    }

    public synchronized static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        } return instance;
    }

}

