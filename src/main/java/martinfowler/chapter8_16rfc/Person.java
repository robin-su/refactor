package martinfowler.chapter8_16rfc;

/**
 * isMale()和getCode都是返回硬编码的常量函数，因此运行Replace Subclass with Fields进行优化
 */
public class Person {

    //3.针对每个常量函数，在超类中声明一个对应的字段
    private final boolean _isMale;
    private final char _code;

    //4.在超类上加上一个Protect构造函数
    //5.让子类加上新的构造器，令他调用超类新增的构造函数
    protected Person(boolean isMale,char code) {
        _isMale = isMale;
        _code = code;
    }

//    abstract boolean isMale();
//    abstract char getCode();
    //6.在超类中加入访问函数，并删除掉子类的访问函数
    boolean isMale() {
        return _isMale;
    }

    char getCode() {
        return _code;
    }

    //1.对所有的子类使用Replace Constructor with Factory Method
    //7.将子类的构函数内连到超类的工厂函数中
    static Person createMale() {
//        return new Male(true,'M');
        return new Person(true,'M');
    }

    static Person createFemale() {
//        return new Female(false,'F');
        return new Person(false,'F');
    }
}
