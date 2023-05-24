package refactoringtopatterns.build.factory.xml;

public class DOMBuilder extends OutputBuilder {

    private String rootName;

    public DOMBuilder(String rootName) {
        this.rootName = rootName;
    }


    @Override
    public void addBelow(String value) {

    }

    @Override
    public void addAbove(String value) {

    }
}
