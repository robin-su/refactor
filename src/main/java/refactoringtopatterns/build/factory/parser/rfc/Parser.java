package refactoringtopatterns.build.factory.parser.rfc;

public class Parser {


    private StringParser stringParser;

    public Parser() {
        this.stringParser = new StringParser(this);
    }

    /**
     * 5.将配置系项挪到NodeFactory
     *
     * @return
     */
    /*public Boolean shouldDecode() {
        return shouldDecode;
    }

    public void setShouldDecode (Boolean shouldDecode) {
        this.shouldDecode = shouldDecode;
    }

    public boolean shouldRemoveEscapeCharacters() {
        return shouldRemoveEscapeCharacters;
    }

    public void setShouldRemoveEscapeCharacters(boolean shouldRemoveEscapeCharacters) {
        this.shouldRemoveEscapeCharacters = shouldRemoveEscapeCharacters;
    }*/

    public Node parse(String url) {
        return this.stringParser.findString(url);
    }

    private NodeFactory nodeFactory;

    public void setNodeFactory(NodeFactory nodeFactory) {
        this.nodeFactory = nodeFactory;
    }

    public NodeFactory getNodeFactory() {
        return nodeFactory;
    }
}

