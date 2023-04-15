package sjmszm.pattern.singleton.parameters;

public class Singleton2 {

    private static Singleton2 instance = null;
    private final int paramA;
    private final int paramB;

    private Singleton2(int paramA, int paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public synchronized static Singleton2 getInstance(int paramA, int paramB) {
        if(instance == null) {
            instance = new Singleton2(paramA,paramB);
        }
        return instance;
    }
}
