package visitor;

public class Shenzhen implements City{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
