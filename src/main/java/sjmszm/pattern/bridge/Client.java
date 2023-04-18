package sjmszm.pattern.bridge;

public class Client {

    public static void main(String[] args) {
        //这里还有构造的空间
        ApiStatInfo apiStatInfo = new ApiStatInfo(null, 0, 0, 0);
        ApplicationContext.getInstance()
                .getAlter()
                .check(apiStatInfo);
    }

}
