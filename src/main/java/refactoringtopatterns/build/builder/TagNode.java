package refactoringtopatterns.build.builder;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TagNode {

    private String tagName;
    private TagNode parent;
    private List<TagNode> child;
    private Map<String,String> attributes;
    private String value;

    public TagNode(String tagName) {
        this.tagName = tagName;
        this.child = new ArrayList<>();
        this.attributes = new HashMap<>();
        this.value = "";
    }

    public void add(TagNode tagNode) {
        // 1.将当前节点设置为父亲节点，记录父亲节点
        tagNode.setParent(this);
        // 2.往孩子节点中添加节点
        this.child.add(tagNode);
    }

    public String toString() {
        StringBuilder tagNodeBuilder = new StringBuilder();
        if(this.isToSingleTag()) {
            return tagNodeBuilder.append("<")
                    .append(this.getTagName())
                    .append("/>")
                    .toString();
        }
        return tagNodeBuilder.append("<")
                .append(this.getTagName())
                .append(StringUtils.isNotBlank(this.getAttributesStr()) ? " " + this.getAttributesStr() : "")
                .append(">")
                .append(getValue())
                .append(getChildrenTagsStr())
                .append("</")
                .append(this.getTagName())
                .append(">")
                .toString();
    }

    private String getAttributesStr() {
        StringBuilder resultBuilder = new StringBuilder();
        attributes.forEach((k,v) -> {
            resultBuilder.append(k)
                    .append("=")
                    .append(v);
        });
        return resultBuilder.toString();
    }

    private String getChildrenTagsStr() {
        return this.child.stream()
                .map(b -> new StringBuilder(b.toString()))
                .reduce(new StringBuilder(),(builder, tagName) -> {
                    builder.append(tagName);
                    return builder;
                }).toString();
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TagNode getParent() {
        return parent;
    }

    public void setParent(TagNode parent) {
        this.parent = parent;
    }

    public void addAttribute(String key, String value){
        this.attributes.put(key,value);
    }

    public String getValue() {
        return value;
    }

    public String getTagName() {
        return tagName;
    }

    public Object getAttributes() {
        return attributes;
    }

    public List<TagNode> getChild() {
        return child;
    }

    private boolean isToSingleTag() {
        return !this.hasChildren() && !this.hasValue();
    }

    private boolean hasChildren() {
        return this.child.size() > 0;
    }

    private boolean hasValue() {
        return this.value.length() > 0;
    }
}
