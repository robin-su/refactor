package refactoringtopatterns.build.state.rfc;

public class PermissionGranted extends PermissionState{
    public PermissionGranted() {
        super("GRANTED");
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
