package refactoringtopatterns.build.decorator.rfc;

class StringParser {

    public Node find(NodeReader reader, String input, int position, boolean balance_quotes) {
        int textBegin = 0;
        int textEnd = 0;
        StringBuffer textBuffer = new StringBuffer();
        //4.3 使用Create Method 创建StringNode
        return StringNode.createStringNode(textBuffer,textBegin,textEnd,
                reader.getParser().shouldDecodeNodes());
    }

}
