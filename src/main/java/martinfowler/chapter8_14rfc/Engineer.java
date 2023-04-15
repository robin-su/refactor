package martinfowler.chapter8_14rfc;

/**
 * 3.为每个类型码建立一个子类，每个子类复写类型码的取值函数，使其返回相应类型码值
 */
public class Engineer extends Employee {

    @Override
    int getType() {
        return Employee.ENGINEER;
    }
}
