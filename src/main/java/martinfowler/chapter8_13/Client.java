package martinfowler.chapter8_13;

public class Client {

    public static void main(String[] args) {
        Person parent = new Person(Person.O);
        if(parent.getBloodGroup() == Person.AB) {

        }
        Person child = new Person(parent.getBloodGroup());
        child.setBloodGroup(parent.getBloodGroup());
    }

}
