package refactoringtopatterns.build.factory.descriptors;

import java.util.Date;

public abstract class AttributeDescriptor {

    private String methodName;
    private Class aClass;
    private Class type;

    protected AttributeDescriptor(String methodName, Class aClass, Class type) {
        this.methodName = methodName;
        this.aClass = aClass;
        this.type = type;
    }


    static AttributeDescriptor forInteger(String methodName, Class aclass) {
        return new DefaultDescriptor(methodName, aclass, Integer.TYPE);
    }

    static DefaultDescriptor forDate(String createDate, Class aClass) {
        return new DefaultDescriptor(createDate, Client.class, Date.class);
    }
}
