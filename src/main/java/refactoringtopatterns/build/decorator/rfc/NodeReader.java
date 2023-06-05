package refactoringtopatterns.build.decorator.rfc;

public class NodeReader {

    private Parser parser;

    public NodeReader() {
        this.parser = new Parser();
    }

    public Parser getParser() {
        return this.parser;
    }

}
