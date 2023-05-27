package refactoringtopatterns.build.factory.xml;

public class XMLBuilder implements OutputBuilder {

    private String rootName;

    public XMLBuilder(String rootName) {
        this.rootName = rootName;
    }

    @Override
    public void addBelow(String value) {

    }

    @Override
    public void addAbove(String value) {

    }
}
