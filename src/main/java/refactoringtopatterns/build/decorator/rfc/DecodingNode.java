package refactoringtopatterns.build.decorator.rfc;

//5.2 新增子类用于处理 shouldDecode = true 的情况
//10.3 让DecodingNode不在是StringNode的子类
//public class DecodingNode extends StringNode {
//10.7 DecodingNode 实现Node，为了让StringNode能通过编译
public class DecodingNode implements Node {

    //10.1 使用委托替代继承，首先在子类DecodingNode中创建一个引用自身的字段
    // 我们把delegate声明为Node而不是DecodingNode，是因为DecodingNode马上就要变成一个Decorator装饰者，
    // 并且他所装饰的对象必须实现与他相同的接口
    //10.4 让delegate指向StringNode事例
//    private Node delegate = this;
    private Node delegate;

    public DecodingNode(StringBuffer textBuffer, int textBegin, int textEnd) {
//        super(textBuffer, textBegin, textEnd);
        //10.5 让delegate指向StringNode事例
        delegate = new StringNode(textBuffer, textBegin, textEnd);
    }

    // 8.2 删除StringNode和DecodingNode中的shouldDecode
//    @Override
//    protected boolean shouldDecode() {
//        return true;
//    }

    // 7.2 将类型码相关的判断逻辑去除，属于子类行的将其移动到子类中去
    public String toPlainTextString() {

        //9.删除textBuffer.toString()和父类型中一致的重复代码
//        return Translate.decode(this.textBuffer.toString());
        //10.2 修改调用父类的方法为委托调用
//        return Translate.decode(super.toPlainTextString());
        // 注意：这里将陷入死循环，注意Martin说的关于委托替代继承的注意事项：
        // 不能替换子类中声明的任何会调用超类的方法，否则他会陷入无限递归。这一方法只有在继承关系被打破的之后才能被替换，所以我们要重点
        // DecodingNode 不是StringNode的子类
        return Translate.decode(delegate.toPlainTextString());
    }

    //10.8.1 让DecodingNode从Node中继承下来的方法都调用委托delegate相应的方法
    @Override
    public String toHtml() {
        return delegate.toHtml();
    }

    //10.8.2 让DecodingNode从Node中继承下来的方法都调用委托delegate相应的方法
    @Override
    public String getText() {
        return delegate.getText();
    }

    //10.8.3 让DecodingNode从Node中继承下来的方法都调用委托delegate相应的方法
    @Override
    public void setText(String text) {
        delegate.setText(text);
    }
}
