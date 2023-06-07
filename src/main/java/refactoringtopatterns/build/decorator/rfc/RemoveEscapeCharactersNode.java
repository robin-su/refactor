package refactoringtopatterns.build.decorator.rfc;

public class RemoveEscapeCharactersNode implements Node  {

    private Node delegate;

    public RemoveEscapeCharactersNode(StringBuffer textBuffer, int textBegin, int textEnd) {
        delegate = new StringNode(textBuffer, textBegin, textEnd);
    }

    @Override
    public String toHtml() {
        return delegate.toHtml();
    }

    @Override
    public String toPlainTextString() {
        return ParserUtils.removeEscapeCharacters(delegate.toPlainTextString());
    }

    @Override
    public String getText() {
        return delegate.toHtml();
    }

    @Override
    public void setText(String text) {
        delegate.setText(text);
    }
}
