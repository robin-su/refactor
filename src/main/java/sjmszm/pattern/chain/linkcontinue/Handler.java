package sjmszm.pattern.chain.linkcontinue;

public abstract class Handler {

    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public void handle() {
        doHandle();
        //...
        if(successor !=null) {
            successor.handle();
        }
    }

    protected abstract boolean doHandle();
}
