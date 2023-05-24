package refactoringtopatterns.build.factory.parser;

public class StringNode implements Node {

    private StringBuffer textBuffer;
    private int textBegin;
    private int textEnd;

    private StringNode(StringBuffer textBuffer,int textBegin, int textEnd) {
        this.textBuffer = textBuffer;
        this.textBegin = textBegin;
        this.textEnd = textEnd;
    }

    public static Node createStringNode(StringBuffer textBuffer,int textBegin, int textEnd, boolean shouldDecode) {
        if(shouldDecode) {
            return new DecodingStringNode(new StringNode(textBuffer,textBegin,textEnd));
        }
        return new StringNode(textBuffer,textBegin,textEnd);
    }

}
