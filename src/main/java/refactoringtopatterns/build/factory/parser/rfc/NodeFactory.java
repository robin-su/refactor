package refactoringtopatterns.build.factory.parser.rfc;

public class NodeFactory {

    private Boolean shouldDecode;
    private boolean shouldRemoveEscapeCharacters;

    public Boolean shouldDecode() {
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
    }



    //2. 将静态方法改成非静态的
    public Node createStringNode(String text) {
        if(shouldDecode) {
            return new DecodingStringNode(text);
        }
        return new StringNode(text);
    }

}
