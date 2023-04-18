package sjmszm.pattern.adapter;

public class Adapter2 implements ITarget{

    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        adaptee.fa();
    }

    @Override
    public void f2() {

    }

    @Override
    public void fc() {

    }
}
