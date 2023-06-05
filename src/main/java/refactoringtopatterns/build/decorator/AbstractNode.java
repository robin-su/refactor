package refactoringtopatterns.build.decorator;


public abstract class AbstractNode implements Node {

    private int nodeBegin;
    private int nodeEnd;

    public AbstractNode(int nodeBegin, int nodeEnd) {
        this.nodeBegin = nodeBegin;
        this.nodeEnd = nodeEnd;
    }
}
