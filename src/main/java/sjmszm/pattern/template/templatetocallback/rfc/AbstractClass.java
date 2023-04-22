package sjmszm.pattern.template.templatetocallback.rfc;

public class AbstractClass {

    private MethodCallback methodCallback;

    public AbstractClass(MethodCallback methodCallback) {
        this.methodCallback = methodCallback;
    }

    public void execute() {
        methodCallback.execute();
    }

}

