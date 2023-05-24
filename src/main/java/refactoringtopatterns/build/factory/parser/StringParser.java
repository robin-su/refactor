package refactoringtopatterns.build.factory.parser;

public class StringParser {

    public Node find(StringBuffer textBuffer, int textBegin, int textEnd, boolean shouldDecode) {
        Parser parser = new Parser();
        return StringNode.createStringNode(textBuffer,textBegin,textEnd,parser.shouldDecode());
    }

}
