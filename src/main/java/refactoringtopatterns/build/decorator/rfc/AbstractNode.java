package refactoringtopatterns.build.decorator.rfc;


/**
 * 目的是为了包装StringNode,但是StringNode又继承自AbstractNode，AbstractNode又继承自Node，
 * 选择包装类型的时候，着重考虑：好的包装类型不回包含字段（例如，状态），AbstractNode中包含int类型的
 * nodeBegin和nodeEnd，因此起不是一个好的包装类型。因为Decorator为他所修饰的对象添加行为时不需要复制
 * 那些对象中的字段。StringNode已经从AbstractNode中继承了nodeBegin，nodeEnd，所以StringNode的Decorator
 * 不再需要继承这些字段
 */
public abstract class AbstractNode implements Node {

    private int nodeBegin;
    private int nodeEnd;

    public AbstractNode(int nodeBegin, int nodeEnd) {
        this.nodeBegin = nodeBegin;
        this.nodeEnd = nodeEnd;
    }
}
