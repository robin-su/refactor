package martinfowler.chapter8_16;

public class Client {

    public static void main(String[] args) {
        Person kent = new Male();
        System.out.println("Person's gender is: " + kent.getCode());
    }

}
