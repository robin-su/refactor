package visitor;

public class SingleVisitor implements Visitor {
    @Override
    public void visit(Beijing beijing) {
        System.out.println("hello Beijing!");
    }

    @Override
    public void visit(Shanghai shanghai) {
        System.out.println("hello Shanghai!");
    }

    @Override
    public void visit(Shenzhen shenzhen) {
        System.out.println("hello Shenzhen!");
    }
}
