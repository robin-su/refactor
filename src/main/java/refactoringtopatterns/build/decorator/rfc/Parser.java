package refactoringtopatterns.build.decorator.rfc;

class Parser {

    private boolean shouldDecodeNodes;
    private boolean shouldRemoveEscapeCharacters;

    private String decodeContent;

    public Parser() {
        this("");
    }

    public Parser(String decodeContent) {
        this.decodeContent = decodeContent;
    }

    private NodeIterator iterator = new NodeIterator();

    public void setShouldRemoveEscapeCharacters(boolean shouldRemoveEscapeCharacters) {
        this.shouldRemoveEscapeCharacters = shouldRemoveEscapeCharacters;
    }

    public void setNodeDecoding(boolean isNodeCoding) {
        this.shouldDecodeNodes = shouldDecodeNodes;
    }

    public NodeIterator elements() {
        return iterator;
    }

    public boolean shouldDecodeNodes() {
        return this.shouldDecodeNodes;
    }

    public boolean shouldRemoveEscapeCharacters() {
        return this.shouldRemoveEscapeCharacters;
    }

    public static Parser createParser(String encodeContent) {
        return new Parser(encodeContent);
    }



}
