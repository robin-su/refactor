package martinfowler.chapter8_16;

/**
 * isMale()和getCode都是返回硬编码的常量函数，因此运行Replace Subclass with Fields进行优化
 */
public abstract class Person {
    abstract boolean isMale();
    abstract char getCode();
}
