package sjmszm.iocrfc;

public class UserServiceTest extends TestCase {

    @Override
    public boolean doTest() {
        System.out.println("I am UserServiceTest");
        return false;
    }

    public static void main(String[] args) {
        JunitApplication.register(new UserServiceTest());
    }
}
