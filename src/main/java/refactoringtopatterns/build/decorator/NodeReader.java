package refactoringtopatterns.build.decorator;

public class NodeReader {

    private Parser parser;

    public NodeReader() {
        this.parser = new Parser();
    }

    public Parser getParser() {
        return this.parser;
    }

}
