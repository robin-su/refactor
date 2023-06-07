package refactoringtopatterns.build.decorator.rfc;

class StringParser {

    private Parser parser;

    public StringParser() {
        this.parser = new Parser();
    }

    public Parser getParser() {
        return this.parser;
    }

    public Node find(NodeReader reader, String input, int position, boolean balance_quotes) {
        int textBegin = 0;
        int textEnd = 0;
        StringBuffer textBuffer = new StringBuffer();
        //4.3 使用Create Method 创建StringNode
        return this.parser.getNodeFactory().createStringNode(textBuffer,textBegin,textEnd);
    }

}
