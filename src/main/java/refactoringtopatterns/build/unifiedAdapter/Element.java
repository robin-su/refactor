package refactoringtopatterns.build.unifiedAdapter;

import java.util.ArrayList;
import java.util.List;

public class Element {

    private String name;
    private String value;
    private String child;

    private List<Element> children = new ArrayList<>();

    public void setAttribute(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Element(String child) {
        this.child = child;
    }

    public void appChild(Element childNode) {
        this.children.add(childNode);
    }







}
