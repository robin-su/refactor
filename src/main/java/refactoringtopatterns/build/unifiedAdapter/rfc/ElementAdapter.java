package refactoringtopatterns.build.unifiedAdapter.rfc;

/**
 * 2.1
 */
//6. 使ElementAdapter 实现 XMLNode
public class ElementAdapter implements XMLNode {

    private Element element;
    // 5.3
    private Document document;


    //5.4
    public ElementAdapter(Element element,Document document) {
        this.element = element;
        this.document = document;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }



    //5.1
    public void addAttribute(String name, String value) {
        getElement().setAttribute(name,value);
    }

    //5.2
    // 6.1
//    public void add(ElementAdapter child) {
//        getElement().appendChild(child.getElement());
//    }

    //6.2
    @Override
    public void add(XMLNode child) {
        ElementAdapter childElement = (ElementAdapter)child;
        getElement().appendChild(childElement.getElement());
    }


    // 5.6
    public void addValue(String value) {
        getElement().appendChild(document.createTextNode(value));
    }
}
