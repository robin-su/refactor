package visitor;

public class Shanghai implements City{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
