package sjmszm.pattern.template.templatetocallback.rfc;

public abstract class MethodTemplate12 implements MethodCallback {

    @Override
    public void execute() {
        method1();
        method2();
    }

    protected abstract void method1();
    protected abstract void method2();
}
