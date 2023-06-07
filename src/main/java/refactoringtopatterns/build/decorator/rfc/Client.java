package refactoringtopatterns.build.decorator.rfc;

public class Client {

    public static void main(String[] args) {
        String ENCODED_WORKSHOP_TITLE = "The Testing &amp; Refactoring Workshop";

        String DECODED_WORKSHOP_TITLE = "The Testing & Refactoring Workshop";

        StringBuffer decodedContent = new StringBuffer();
        Parser parser = Parser.createParser(ENCODED_WORKSHOP_TITLE);
        NodeFactory nodeFactory = new NodeFactory();
        nodeFactory.setShouldDecode(true);
        nodeFactory.setShouldRemoveEscapeCharacters(true);
        parser.setNodeFactory(nodeFactory);
//        parser.setNodeDecoding(true);
        NodeIterator nodes = parser.elements();

        while(nodes.hasNext()) {
            decodedContent.append(nodes.next().toPlainTextString());
        }

        assert DECODED_WORKSHOP_TITLE.equals(decodedContent.toString());
    }

}
