package refactoringtopatterns.build.factory.xml.rfc;


public class DOMBuilderTest extends AbstractBuilderTest {

    @Override
    public OutputBuilder createBuilder(String rootName) {
        return new DOMBuilder(rootName);
    }

    @Override
    public boolean doTest() {
        return false;
    }
}
