package refactoringtopatterns.build.decorator;

class StringParser {

    public Node find(NodeReader reader,String input, int position, boolean balance_quotes) {
        int textBegin = 0;
        int textEnd = 0;
        StringBuffer textBuffer = new StringBuffer();
        return new StringNode(textBuffer,textBegin,textEnd,
                reader.getParser().shouldDecodeNodes(),
                reader.getParser().shouldRemoveEscapeCharacters());
    }

}
