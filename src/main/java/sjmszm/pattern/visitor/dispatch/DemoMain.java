package sjmszm.pattern.visitor.dispatch;

public class DemoMain {

    public static void main(String[] args) {
        SingleDispatchClass demo = new SingleDispatchClass();
        ParentClass p = new ChildClass();
        demo.polymorphismFunction(p);
        demo.overloadFunction(p);
    }

}
