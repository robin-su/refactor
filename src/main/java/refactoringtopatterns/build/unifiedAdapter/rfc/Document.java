package refactoringtopatterns.build.unifiedAdapter.rfc;

public class Document {


    public Element createElement(String child) {
        return new Element(child);
    }


    public Element createTextNode(String value) {
        return new Element(value);
    }
}
