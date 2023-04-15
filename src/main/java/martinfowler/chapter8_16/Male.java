package martinfowler.chapter8_16;

public class Male extends Person{

    @Override
    boolean isMale() {
        return true;
    }

    @Override
    char getCode() {
        return 'M';
    }
}
