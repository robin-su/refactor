package refactoringtopatterns.build.factory.parser.rfc;

public class Parser {

    private NodeFactory nodeFactory;

    public NodeFactory getNodeFactory() {
        return nodeFactory;
    }

    public void setNodeFactory(NodeFactory nodeFactory) {
        this.nodeFactory = nodeFactory;
    }
}


