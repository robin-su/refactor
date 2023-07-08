package refactoringtopatterns.build.unifiedAdapter.rfc;

import java.util.Stack;

/**
 * 2. 为了产生一个Element的适配器，在DOMBuilder上应用提炼类重构
 */
// 4. 为每个被DOMBuilder调用的被适配者方法创建一个被适配者调用方法。使用提炼方法重构，确保每个提炼出来的方法都接受一个被适配者作为参数
// 5. 使用搬移方法重构，将每个`被适配者`调用方法搬移到ElementAdapter中。注意被搬移的方法与公共接口【XMLNode】中的方法要尽量相似
//    addValue(ElementAdapter current,String value)方法就做不到，因为他跟依赖于document，这里可以通过 ElementAdapter 添加Document
//    成员变量，并且通过ElementAdapter的构造器传入参数来初始化
// 7. 更新所有的ElmentAdpater为XMLNode
// 8. 使用Template Method 和 Factory Method 重构引入多态创建来重构
public class DOMBuilder extends AbstractBuilder {

    private static final String CANNOT_ADD_BESIDE_ROOT = "CANNOT_ADD_BESIDE_ROOT";

    private Document document;
    /**
     * 3.使所有的Element字段都替换成 ElementAdapter 类型
     */
//    private Element root;
//    private Element parent;
//    private Element current;

//    private ElementAdapter rootNode;
//    private ElementAdapter parentNode;
//    private ElementAdapter currentNode;

    // 3.3
//    private Stack<ElementAdapter> history = new Stack<>();
    private Stack<XMLNode> history = new Stack<>();

    //3.1
    public void addAttribute(String name, String value) {
        //4.2
//        currentNode.getElement().setAttribute(name, value);
        currentNode.addAttribute(name, value);
    }

    //3.2 注意方法名字更改
    public void addChild(String child) {

        // 8.1
        XMLNode childNode =
                createNode(child);
//        4.4
//        currentNode.getElement().appendChild(childNode.getElement());
        currentNode.add(childNode);
        parentNode = currentNode;
        currentNode = childNode;
        history.push(currentNode);
    }

    /**
     * 8.2
     */
    /**
     * 8.3 返回的一定是DomBuilder和XMLBuilder共同的签名返回值，所以是XMLNode
     */
    @Override
    public XMLNode createNode(String child) {
        return new ElementAdapter(document.createElement(child), document);
    }

    // 3.3 注意方法名字更改
    public void addBeside(String sibling) {
        if(currentNode == rootNode) {
            throw new RuntimeException(CANNOT_ADD_BESIDE_ROOT);
        }
        XMLNode siblingNode = createNode(sibling);
//        parentNode.getElement().appendChild(siblingNode.getElement());
        // 4.5
        parentNode.add(siblingNode);
        currentNode = siblingNode;
        history.pop();
        history.push(currentNode);
    }

    //3.4
    public void addValue(String value) {
//        currentNode.getElement().appendChild(document.createTextNode(value));
//        currentNode.addValue(currentNode, value);
        currentNode.addValue(value);
    }
//    public void addValue(ElementAdapter current,String value) {
//        current.getElement().appendChild(document.createTextNode(value));
//    }
}
