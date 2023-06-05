package refactoringtopatterns.build.decorator;

public class StringNode extends AbstractNode {

    private boolean shouldDecode = false;
    private boolean shouldRemoveEscapeCharacters = false;
    private StringBuffer textBuffer;

    private String text;

    public StringNode(StringBuffer textBuffer,
                      int textBegin,
                      int textEnd,
                      boolean shouldDecode,
                      boolean shouldRemoveEscapeCharacters){
        this(textBuffer, textBegin,textEnd);
        this.shouldDecode = shouldDecode;
        this.shouldRemoveEscapeCharacters = shouldRemoveEscapeCharacters;
    }

    public StringNode(StringBuffer textBuffer,
                      int textBegin,
                      int textEnd) {
        super(textBegin,textEnd);
        this.textBuffer = textBuffer;
    }

    @Override
    public String toHtml() {
        return null;
    }

    @Override
    public String toPlainTextString() {
        String result = this.textBuffer.toString();
        if(this.shouldDecode) {
            result = Translate.decode(result);
        }

        if(this.shouldRemoveEscapeCharacters) {
            result = ParserUtils.removeEscapeCharacters(result);
        }
        return result;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
