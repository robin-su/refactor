package refactoringtopatterns.build.factory.parser;

public class DecodingStringNode implements Node {

    private String text;

    public DecodingStringNode(String text) {
        this.text = text;
    }
}
