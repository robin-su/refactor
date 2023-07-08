package refactoringtopatterns.build.unifiedAdapter.rfc;

public abstract class AbstractBuilder {


    /**
     * 8.3 上移动
     */
    protected XMLNode rootNode;
    protected XMLNode currentNode;
    protected XMLNode parentNode;


    public void addChild(String child) {

        // 8.1
        XMLNode childNode =
                createNode(child);
//        4.4
//        currentNode.getElement().appendChild(childNode.getElement());
        currentNode.add(childNode);
        parentNode = currentNode;
        currentNode = childNode;
    }


    protected abstract XMLNode createNode(String child);

}
