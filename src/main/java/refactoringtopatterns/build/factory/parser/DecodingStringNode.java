package refactoringtopatterns.build.factory.parser;

public class DecodingStringNode implements Node {

    private Node node;

    public DecodingStringNode(Node node) {
        this.node = node;
    }
}
