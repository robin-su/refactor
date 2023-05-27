package refactoringtopatterns.build.builder;

public class TagBuilder {

    private TagNode rootNode;
    private TagNode currentNode;

    public TagBuilder(String rootTagName) {
        this.rootNode = new TagNode(rootTagName);
        currentNode = rootNode;
    }

    public void addChild(String rootTagName) {
        TagNode parentNode = currentNode;
        TagNode tagNode = new TagNode(rootTagName);
//        parentNode.parentNode
    }

    public String toXml() {
        return this.rootNode.toString();
    }

}
