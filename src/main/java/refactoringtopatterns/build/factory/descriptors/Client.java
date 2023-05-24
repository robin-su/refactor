package refactoringtopatterns.build.factory.descriptors;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        getResult();

    }

    private static List<AttributeDescriptor> getResult() {
        List<AttributeDescriptor> result = new ArrayList<>();
        result.add(AttributeDescriptor.forInteger("remoteId", Client.class));
        result.add(AttributeDescriptor.forDate("createDate",Client.class));
        result.add(AttributeDescriptor.forDate("lastChangedDate",Client.class));
        result.add(new ReferenceDescriptor("createdBy", Client.class, User.class, RemoteUser.class));
        result.add(AttributeDescriptor.forInteger("optimisticLockVersion", Client.class));
        return result;
    }

}
