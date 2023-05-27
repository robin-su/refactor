package refactoringtopatterns.build.builder;

public class TagNode {

    private String rootName;
    private TagNode parent;
    private TagNode childNode;

    public TagNode(String rootName) {
        this.rootName = rootName;
    }

    public void add(TagNode node) {
        childNode.setParent(node);
        
    }

    public void setParent(TagNode parent) {
        this.parent = parent;
    }

    public String toString() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<")
                /*.append(rootName)
                .append(">")
                .append("<")*/
                .append(rootName)
                .append("/>")
                ;
        return xmlBuilder.toString();
    }
}
