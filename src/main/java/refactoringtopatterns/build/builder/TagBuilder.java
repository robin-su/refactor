package refactoringtopatterns.build.builder;

public class TagBuilder {

    private TagNode rootNode;
    private TagNode currentNode;

    public TagBuilder(String rootTagName) {
        this.rootNode = new TagNode(rootTagName);
        // 初始化的时候，当前节点就是root节点，两个引用指向同一个地址
        this.currentNode = rootNode;
    }

    public void addAttribute(String attribute,String value) {
        this.currentNode.addAttribute(attribute,value);
    }

    public void setValue(String value) {
        this.currentNode.setValue(value);
    }

    public void addToParent(String parentTagName, String childTagName) {
        TagNode parentNode = findParentBy(parentTagName);
        if(parentNode == null) {
            throw new RuntimeException(String.format("missing parent tag %s",parentTagName));
        }
        addTo(parentNode,childTagName);
    }

    private TagNode findParentBy(String parentName) {
        TagNode parentNode = currentNode;
        while(parentNode != null) {
            if(parentName.equals(parentNode.getTagName())) {
                return parentNode;
            }
            parentNode = parentNode.getParent();
        }
        return null;
    }

    public void addChild(String childTagName) {
        // 当前节点作为父亲节点
//        TagNode parentNode = currentNode;
        // 当前节点指向新创建的节点 -> 孩子节点
        addTo(currentNode, childTagName);
    }

    public void addSibling(String siblingTagName) {
        // 1.获取当前节点的父亲节点
//        TagNode parent = currentNode.getParent();
        addTo(currentNode.getParent(), siblingTagName);
    }

    private void addTo(TagNode parent, String siblingTagName) {
        // 2.创建兄弟节点
        currentNode = new TagNode(siblingTagName);
        // 3.往父亲节点中添加新的孩子节点为当前创建的兄弟节点
        parent.add(currentNode);
    }

    public String toXml() {
        return this.rootNode.toString();
    }
}
