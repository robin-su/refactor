package refactoringtopatterns.build.unifiedAdapter;

import java.util.ArrayList;
import java.util.List;

public class TagNode {

    private String tagName;

    private String attribute;
    private String value;

    private TagNode parentNode;

    private StringBuffer attributes;

    private List<TagNode> children;

    public TagNode(String tagName) {
        this.tagName = tagName;
    }

    public TagNode getParent() {
        return parentNode;
    }

    private List<TagNode> children() {
        if(children == null) {
            children = new ArrayList<>();
        }
        return children;
    }

    public void add(TagNode child) {
        children().add(child);
    }


    public void addValue(String value) {
        this.value = value;
    }

    public void addAttribute(String attribute, String value) {
        attributes.append(" ");
        attributes.append(attributes);
        attributes.append("='");
        attributes.append(value);
        attributes.append("'");
    }

}
