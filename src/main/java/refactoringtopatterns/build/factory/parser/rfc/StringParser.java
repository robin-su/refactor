package refactoringtopatterns.build.factory.parser.rfc;

public class StringParser {

    public Node find(StringBuffer textBuffer, int textBegin, int textEnd, boolean shouldDecode) {
        Parser parser = new Parser();
        return parser.getNodeFactory().createStringNode(textBuffer,
                textBegin,
                textEnd);
    }

}
