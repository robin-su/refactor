package refactoringtopatterns.build.factory.xml;

import sjmszm.iocrfc.TestCase;

public class DOMBuilderTest extends TestCase {

    private OutputBuilder outputBuilder;

    public void testAddAboveRoot() {
        String invalidResult =
                "<orders>" +
                        "<order>" +
                        "</order>" +
                "<orders>" +
                "<customer>" +
                "</customer>";
        outputBuilder = new DOMBuilder("orders");
        outputBuilder.addBelow("order");
        try {
            outputBuilder.addAbove("customer");
        } catch (RuntimeException ignored){}
    }

    @Override
    public boolean doTest() {
        return false;
    }
}
