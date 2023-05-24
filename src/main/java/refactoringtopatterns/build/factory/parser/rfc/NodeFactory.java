package refactoringtopatterns.build.factory.parser.rfc;

public class NodeFactory {
    private boolean decodeStringNodes;

    public boolean shouldDecodeStringNodes() {
        return decodeStringNodes;
    }

    public void setDecodeStringNodes(boolean decodeStringNodes) {
        this.decodeStringNodes = decodeStringNodes;
    }

    public Node createStringNode(StringBuffer textBuffer, int textBegin, int textEnd) {
        if(decodeStringNodes) {
            return new DecodingStringNode(new StringNode(textBuffer,textBegin,textEnd));
        }
        return new StringNode(textBuffer,textBegin,textEnd);
    }
}
