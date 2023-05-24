package refactoringtopatterns.build.factory.xml.rfc;

public class XMLBuilderTest extends AbstractBuilderTest  {

    @Override
    public OutputBuilder createBuilder(String rootName) {
        return new XMLBuilder(rootName);
    }

    @Override
    public boolean doTest() {
        return false;
    }
}
