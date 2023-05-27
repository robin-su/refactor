package refactoringtopatterns.build.factory.parser.rfc;

public class StringNode implements Node {

    private String text;
    private String type;

    public StringNode(String text) {
        this.type = "default";
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getType() {
        return type;
    }

    //1.提取到NodeFactory
    /*public static Node createStringNode(String text, boolean shouldDecode, boolean shouldRemoveEscapeCharacters) {
        if(shouldDecode) {
            return new DecodingStringNode(text);
        }
        return new StringNode(text);
    }*/

}
