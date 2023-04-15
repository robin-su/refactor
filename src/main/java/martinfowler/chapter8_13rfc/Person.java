package martinfowler.chapter8_13rfc;

public class Person {
    /**
     * 2. 维持原先以类型码为基础的函数接口，但改变静态字段，以新建的类产生代码
     *    然后，修改类型码相关的函数，让他们从新建的类中获取类型码
     */
//    public static final int O = BloodGroup.O.getCode();
//    public static final int A = BloodGroup.A.getCode();
//    public static final int B = BloodGroup.B.getCode();
//    public static final int AB = BloodGroup.AB.getCode();

    private BloodGroup bloodGroup;

//    public Person(int code) {
//        bloodGroup = BloodGroup.code(code);
//    }

    /**
     * 4. 建立一个"以新类BloodGroup实例为自变量"的函数，用以替换原先"直接以类型码为参数"的函数，
     *    例如构造器和设值函数的参数改为BloodGroup
     *    mark: 本质是让客户端调用的时候使用新类
     */
    public Person(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setBloodGroup(BloodGroup arg) {
        this.bloodGroup = arg;
    }

    /**
     * 5. 建立一个以"返回新类BloodGroup实例"的函数，用以替换原先"直接返回类型码"的函数
     */
    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    /**
     * 8. 删掉原本使用整形类型的那些旧的取值函数、构造函数、静态变量和设值函数
     */

    // 3. 重命名
//    public int getBloodGroupCode() {
//        return bloodGroup.getCode();
//    }

//    public void setBloodGroup(int arg) {
////        this.bloodGroup = bloodGroup;
//        bloodGroup = BloodGroup.code(arg);
//    }
}
