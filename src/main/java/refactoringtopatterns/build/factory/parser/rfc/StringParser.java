package refactoringtopatterns.build.factory.parser.rfc;

public class StringParser {

    private Parser parser;

    public StringParser(Parser parser) {
        this.parser = parser;
    }

    public Node findString(String url) {

        // 4.修改成使用NodeFactory来调用
//        NodeFactory nodeFactory = new NodeFactory();
        NodeFactory nodeFactory = this.parser.getNodeFactory();
        return nodeFactory.createStringNode(
                url/*,
                parser.shouldDecode(),
                parser.shouldRemoveEscapeCharacters()*/);


        /*return StringNode.createStringNode(
                url,
                this.parser.shouldDecode(),
                this.parser.shouldRemoveEscapeCharacters()
        );*/
    }
}
