package refactoringtopatterns.build.factory.descriptors;

public class ReferenceDescriptor extends AttributeDescriptor {

    private Class bClass;

    public ReferenceDescriptor(String methodName, Class aClass, Class type,Class bClass) {
        super(methodName, aClass, type);
        this.bClass = bClass;
    }
}
