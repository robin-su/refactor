package refactoringtopatterns.build.decorator.rfc;

public class NodeFactory {

    private boolean shouldDecode;
    private boolean shouldRemoveEscapeCharacters = false;

    public boolean shouldDecode() {
        return shouldDecode;
    }

    public void setShouldDecode(boolean shouldDecode) {
        this.shouldDecode = shouldDecode;
    }

    public boolean shouldRemoveEscapeCharacters() {
        return shouldRemoveEscapeCharacters;
    }

    public void setShouldRemoveEscapeCharacters(boolean shouldRemoveEscapeCharacters) {
        this.shouldRemoveEscapeCharacters = shouldRemoveEscapeCharacters;
    }

    public Node createStringNode(StringBuffer textBuffer,
                                 int textBegin,
                                 int textEnd) {
        if(shouldDecode) {
            // 10.6 此时DecodingNode不再继承与Node，应该让DecodingNode实现Node
            return new DecodingNode(textBuffer,textBegin,textEnd);
        }
        if(shouldRemoveEscapeCharacters) {
            return new RemoveEscapeCharactersNode(textBuffer,textBegin,textEnd);
        }
        return new StringNode(textBuffer, textBegin, textEnd);
    }


}
