package refactoringtopatterns.build.unifiedAdapter.rfc;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. TagNode是客户代码的首选，从中提取出公共接口XMLNode方法：
 *    void add(TagNode child);
 *    void addValue(String value);
 *    void addAttribute(String attribute, String value);
 *
 */
//1.2
public class TagNode implements XMLNode {

    private String tagName;

    private String attribute;
    private String value;

    private TagNode parentNode;

    private StringBuffer attributes;

    // 1.4
    private List<XMLNode> children;

    public TagNode(String tagName) {
        this.tagName = tagName;
    }

    public TagNode getParent() {
        return parentNode;
    }

    //1.5
    private List<XMLNode> children() {
        if(children == null) {
            children = new ArrayList<>();
        }
        return children;
    }

//    public void add(TagNode child) {
//        children().add(child);
//    }

    /**
     * 1.3
     * @param childNode
     */
    @Override
    public void add(XMLNode childNode) {
        children.add(childNode);
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
