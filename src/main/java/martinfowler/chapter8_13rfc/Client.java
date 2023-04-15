package martinfowler.chapter8_13rfc;

public class Client {

    public static void main(String[] args) {
        // 7. 修改客户端行为，为调用新类进行构造与调用
//        Person parent = new Person(Person.O);
        Person parent = new Person(BloodGroup.O);
        if(parent.getBloodGroup() == BloodGroup.AB) {

        }
        Person child = new Person(parent.getBloodGroup());
        child.setBloodGroup(parent.getBloodGroup());
    }

}
