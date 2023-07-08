package refactoringtopatterns.build.unifiedAdapter;

import java.util.Stack;

public class DOMBuilder extends AbstractBuilder {

    private static final String CANNOT_ADD_BESIDE_ROOT = "CANNOT_ADD_BESIDE_ROOT";

    private Document document;
    private Element root;
    private Element parent;
    private Element current;

    private Stack<Element> history = new Stack<>();

    public void addAttribute(String name, String value) {
        current.setAttribute(name, value);
    }

    public void addBelow(String child) {
        Element childNode = document.createElement(child);
        current.appChild(childNode);
        parent = current;
        current = childNode;
        history.push(current);
    }

    public void addBeside(String sibling) {
        if(current == root) {
            throw new RuntimeException(CANNOT_ADD_BESIDE_ROOT);
        }
        Element siblingNode = document.createElement(sibling);
        parent.appChild(siblingNode);
        current = siblingNode;
        history.pop();
        history.push(current);
    }

    public void addValue(String value) {
        current.appChild(document.createTextNode(value));
    }

}
