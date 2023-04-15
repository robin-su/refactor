package sjmszm.ioc;

public class UserServiceTest {

    public static boolean doTest() {
        System.out.println("doTest()");
        return true;
    }

    public static void main(String[] args) {
        if(doTest()) {
            System.out.println("Test succeed.");
        } else {
            System.out.println("Test failed.");
        }
    }

}
