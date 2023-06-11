package refactoringtopatterns.build.compositeTree.rfc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1.先提取隐含树的通用叶子节点
 * 2.再考虑结构中的双亲节点
 */
public class TagNode {

    private String name = "";
    private String value = "";
    private StringBuffer attributes;

    private List<TagNode> children;

    public TagNode(String name) {
        this.name = name;
    }

    public void addAttribute(String attribute, String value) {
        attributes.append(" ");
        attributes.append(attributes);
        attributes.append("='");
        attributes.append(value);
        attributes.append("'");
    }

    public void addValue(String value) {
        this.value = value;
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


    public String toString() {
//        String result ;
//        result = "<" + name + attributes + ">"
//                + value +
//                "</" + name + ">";
//        return result;
        String result;
        result = "<" + name + attributes + ">";
        Iterator<TagNode> it = children().iterator();
        while (it.hasNext()) {
            TagNode node = it.next();
            result += node.toString();
        }
        result += value;
        return result += "</" + name + ">";
    }

}
