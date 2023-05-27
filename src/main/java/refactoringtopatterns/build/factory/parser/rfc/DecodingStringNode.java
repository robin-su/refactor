package refactoringtopatterns.build.factory.parser.rfc;

public class DecodingStringNode implements Node {

    private String text;
    private String type;

    public DecodingStringNode(String text) {
        this.type = "decode";
        this.text = text;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public String getType() {
        return this.type;
    }
}
