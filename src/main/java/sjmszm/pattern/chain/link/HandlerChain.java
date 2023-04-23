package sjmszm.pattern.chain.link;

public class HandlerChain {

    private Handler head = null;
    private Handler tail = null;

    /**
     * 构建链表
     *
     * @param handler
     */
    public void addHandler(Handler handler) {
        handler.setSuccessor(null);

        if(head == null) {
            head = handler;
            tail = handler;
            return;
        }

        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle() {
        if(head != null) {
            head.handle();
        }
    }

}
