package refactoringtopatterns.build.decorator.rfc;

class Parser {

    private String decodeContent;

    private NodeFactory nodeFactory;

    public NodeFactory getNodeFactory() {
        return nodeFactory;
    }

    public void setNodeFactory(NodeFactory nodeFactory) {
        this.nodeFactory = nodeFactory;
    }

    public Parser() {
        this("");
    }

    private Parser(String decodeContent) {
        this.decodeContent = decodeContent;
    }

    private NodeIterator iterator = new NodeIterator();

    public NodeIterator elements() {
        return iterator;
    }

    public static Parser createParser(String encodeContent) {
        return new Parser(encodeContent);
    }



}
