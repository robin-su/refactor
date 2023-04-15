package martinfowler.chapter8_16;

public class Female extends Person{
    @Override
    boolean isMale() {
        return false;
    }

    @Override
    char getCode() {
        return 'F';
    }
}
