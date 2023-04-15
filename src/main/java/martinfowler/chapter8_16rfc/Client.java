package martinfowler.chapter8_16rfc;

public class Client {

    public static void main(String[] args) {

        //2.任何引用子类的，让他直接引用超类
//        Person kent = new Male();
        Person kent = Person.createMale();
        System.out.println("Person's gender is: " + kent.getCode());
    }

}
