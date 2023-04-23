package sjmszm.pattern.chain.link;

public class HandlerB extends Handler {

    /**
     * 处理器类的 handle() 函数，不仅包含自己的业务逻辑，还包含对下一个处理器的调用，也就是代码中的 successor.handle()。
     * 一个不熟悉这种代码结构的程序员，在添加新的处理器类的时候，很有可能忘记在 handle() 函数中调用 successor.handle()，
     * 这就会导致代码出现 bug。
     * 我们对代码进行重构，利用模板模式，将调用 successor.handle() 的逻辑从具体的处理器类中剥离出来，放到抽象父类中.见linkrfc
     */
    @Override
    public void handle() {
        boolean handled = false;
        //...
        if(!handled && successor !=null) {
            successor.handle();
        }

    }
}
