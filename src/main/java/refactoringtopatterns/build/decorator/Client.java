package refactoringtopatterns.build.decorator;

import java.util.Iterator;

public class Client {

    public static void main(String[] args) {
        String ENCODED_WORKSHOP_TITLE = "The Testing &amp; Refactoring Workshop";

        String DECODED_WORKSHOP_TITLE = "The Testing & Refactoring Workshop";

        StringBuffer decodedContent = new StringBuffer();
        Parser parser = Parser.createParser(ENCODED_WORKSHOP_TITLE);
        parser.setNodeDecoding(true);
        NodeIterator nodes = parser.elements();

        while(nodes.hasNext()) {
            decodedContent.append(nodes.next().toPlainTextString());
        }

        assert DECODED_WORKSHOP_TITLE.equals(decodedContent.toString());
    }

}
