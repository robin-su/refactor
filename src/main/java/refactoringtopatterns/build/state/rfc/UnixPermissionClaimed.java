package refactoringtopatterns.build.state.rfc;

public class UnixPermissionClaimed extends PermissionState {
    protected UnixPermissionClaimed() {
        super("UNIX_CLAIMED");
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
