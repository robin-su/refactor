package refactoringtopatterns.build.decorator.rfc;

public class Tag extends AbstractNode {

    public Tag(int nodeBegin, int nodeEnd) {
        super(nodeBegin, nodeEnd);
    }

    @Override
    public String toHtml() {
        return null;
    }

    @Override
    public String toPlainTextString() {
        return null;
    }
}
