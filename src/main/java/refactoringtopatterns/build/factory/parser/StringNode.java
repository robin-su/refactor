package refactoringtopatterns.build.factory.parser;

public class StringNode implements Node {

    private String text;
    private String type;

    public StringNode(String text) {
        this.type = "default";
        this.text = text;
    }

    public static Node createStringNode(String text, boolean shouldDecode, boolean shouldRemoveEscapeCharacters) {
        if(shouldDecode) {
            return new DecodingStringNode(text);
        }
        return new StringNode(text);
    }

}
