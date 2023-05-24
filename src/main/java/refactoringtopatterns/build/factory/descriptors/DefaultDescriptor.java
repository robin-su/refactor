package refactoringtopatterns.build.factory.descriptors;

public class DefaultDescriptor extends AttributeDescriptor {
    protected DefaultDescriptor(String methodName, Class aClass, Class type) {
        super(methodName, aClass, type);
    }
}
