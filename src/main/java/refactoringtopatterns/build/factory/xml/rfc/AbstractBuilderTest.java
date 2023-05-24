package refactoringtopatterns.build.factory.xml.rfc;

import sjmszm.iocrfc.TestCase;

public abstract class AbstractBuilderTest extends TestCase {

    protected OutputBuilder outputBuilder;

    public void testAddAboveRoot() {
        String invalidResult =
                "<orders>" +
                        "<order>" +
                        "</order>" +
                        "<orders>" +
                        "<customer>" +
                        "</customer>";
        outputBuilder = createBuilder("orders");
        outputBuilder.addBelow("order");
        try {
            outputBuilder.addAbove("customer");
        } catch (RuntimeException ignored){}
    }
    protected abstract OutputBuilder createBuilder(String rootName);

    @Override
    public boolean doTest() {
        return false;
    }



}
