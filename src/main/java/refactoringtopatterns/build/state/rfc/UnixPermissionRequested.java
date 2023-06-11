package refactoringtopatterns.build.state.rfc;

public class UnixPermissionRequested extends PermissionState {
    protected UnixPermissionRequested() {
        super("UNIX_REQUESTED");
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
