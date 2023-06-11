package refactoringtopatterns.build.state.rfc;

public class PermissionDenied extends PermissionState {
    protected PermissionDenied() {
        super("DENIED");
    }

    @Override
    void claimedBy(SystemAdmin admin, SystemPermission permission) {

    }

    @Override
    void deniedBy(SystemAdmin admin, SystemPermission permission) {

    }

    @Override
    void grantedBy(SystemAdmin admin, SystemPermission permission) {

    }
}
