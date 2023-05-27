package refactoringtopatterns.build.factory.parser;

public class StringParser {

    private Parser parser;

    public StringParser(Parser parser) {
        this.parser = parser;
    }

    public Node findString(String url) {
        return StringNode.createStringNode(
                url,
                this.parser.shouldDecode(),
                this.parser.shouldRemoveEscapeCharacters()
        );
    }
}
