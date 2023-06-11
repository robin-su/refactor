package refactoringtopatterns.build.state.rfc;

public class PermissionClaimed extends PermissionState {
    protected PermissionClaimed() {
        super("CLAIMED");
    }

    @Override
    void claimedBy(SystemAdmin admin, SystemPermission permission) {

    }

    public void deniedBy(SystemAdmin admin, SystemPermission permission) {
//        if(!permission.getState().equals(PermissionState.CLAIMED) && !permission.getState().equals(PermissionState.UNIX_CLAIMED)) {
//            return;
//        }
        if(!permission.getAdmin().equals(admin)) {
            return;
        }
//        isGrand = false;
        permission.setGrand(false);
//        isUnixPermissionGranted = false;
        permission.setUnixPermissionGranted(false);
//        state = DENIED;
        permission.setState(PermissionState.DENIED);
        permission.notifyAdminOfPermissionResult();
    }

    public void grantedBy(SystemAdmin admin,SystemPermission permission) {
//        if(!permission.getState().equals(PermissionState.CLAIMED) && !permission.getState().equals(PermissionState.UNIX_CLAIMED)) {
//            return;
//        }
        if(permission.getAdmin().equals(admin)) {
            return;
        }
      /*  if(permission.getProfile().isUnixPermissionRequired() && permission.getState().equals(PermissionState.UNIX_CLAIMED)) {
            permission.setUnixPermissionGranted(true);
        } else*/
        if(permission.getProfile().isUnixPermissionRequired() && !permission.isUnixPermissionGranted()) {
//            state = UNIX_CLAIMED;
            permission.setState(PermissionState.UNIX_CLAIMED);
            permission.notifyAdminOfPermissionRequest();
            return;
        }
//        state = GRANTED;
        permission.setState(PermissionState.GRANTED);
//        isGrand =true;
        permission.setGrand(true);
        permission.notifyAdminOfPermissionResult();
    }



}
