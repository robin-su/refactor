package refactoringtopatterns.build.decorator;

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
