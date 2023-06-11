package refactoringtopatterns.build.state.rfc;

public class PermissionRequested extends PermissionState {

    public PermissionRequested() {
        super("REQUIRED");
    }

    public void claimedBy(SystemAdmin admin, SystemPermission permission) {

        // 从REQUIRED开始，不再关注别的状态，当前类也保证了一定是REQUIRED状态
        /*if(!permission.getState().equals(PermissionState.REQUIRED) && !permission.getState().equals(PermissionState.UNIX_REQUESTED)) {
            return;
        }
        permission.willBeHandledBy(admin);
        if(permission.getState().equals(PermissionState.REQUIRED)) {
            permission.setState(PermissionState.CLAIMED);
        } else if(permission.getState().equals(PermissionState.UNIX_REQUESTED)) {
            permission.setState(PermissionState.UNIX_CLAIMED);
        }*/

        permission.willBeHandledBy(admin);
        permission.setState(PermissionState.CLAIMED);
    }

    @Override
    void deniedBy(SystemAdmin admin, SystemPermission permission) {

    }

    @Override
    void grantedBy(SystemAdmin admin, SystemPermission permission) {

    }
}
