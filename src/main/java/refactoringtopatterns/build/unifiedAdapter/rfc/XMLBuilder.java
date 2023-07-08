package refactoringtopatterns.build.unifiedAdapter.rfc;

public class XMLBuilder extends AbstractBuilder {

    /**
     * 8.1 上移
     */
//    private TagNode rootNode;
//    private TagNode currentNode;

//    public void addChild(String childTagName) {
////        addTo(currentNode, childTagName);
//        currentNode = createNode(childTagName);
//        parentNode.add(currentNode);
//    }

    public void addSibling(String siblingTagName) {
        addTo(parentNode, siblingTagName);
    }

    public void addAttribute(String name,String value) {
        currentNode.addAttribute(name,value);
    }

    public void addValue(String value) {
        currentNode.addValue(value);
    }

    private void addTo(XMLNode parentNode, String tagName) {
        currentNode = createNode(tagName);
        parentNode.add(currentNode);
    }

    @Override
    public XMLNode createNode(String tagName) {
        return new TagNode(tagName);
    }


}
