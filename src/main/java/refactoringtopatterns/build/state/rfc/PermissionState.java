package refactoringtopatterns.build.state.rfc;

//1.使用类代替SystemPermission中的类型码字段
//3.将6个常量变成PermissionState的子类实例
public abstract class PermissionState {

    private String name;

    protected PermissionState(String name) {
        this.name = name;
    }

    //1.1 将类型码改成PermissionState类
    public final static PermissionState REQUIRED = new PermissionRequested();
    public final static PermissionState CLAIMED = new PermissionClaimed();
    public final static PermissionState GRANTED = new PermissionGranted();
    public final static PermissionState DENIED = new PermissionDenied();
    public final static PermissionState UNIX_REQUESTED = new UnixPermissionRequested();
    public final static PermissionState UNIX_CLAIMED = new UnixPermissionClaimed();

    public String toString() {
        return name;
    }
    // 该方法从 REQUIRED -> CLAIMED,所以帮到PermissionRequest中
    /*public void claimedBy(SystemAdmin admin, SystemPermission permission) {
        if(!permission.getState().equals(PermissionState.REQUIRED) && !permission.getState().equals(PermissionState.UNIX_REQUESTED)) {
            return;
        }
        permission.willBeHandledBy(admin);
        if(permission.getState().equals(PermissionState.REQUIRED)) {
            permission.setState(PermissionState.CLAIMED);
        } else if(permission.getState().equals(PermissionState.UNIX_REQUESTED)) {
            permission.setState(PermissionState.UNIX_CLAIMED);
        }
    }*/

    abstract void claimedBy(SystemAdmin admin, SystemPermission permission);

    // 该方法从 CLAIMED -> DENIED,所以帮到PermissionGranted中
    abstract void deniedBy(SystemAdmin admin,SystemPermission permission);
//    public void deniedBy(SystemAdmin admin,SystemPermission permission) {
//        if(!permission.getState().equals(PermissionState.CLAIMED) && !permission.getState().equals(PermissionState.UNIX_CLAIMED)) {
//            return;
//        }
//        if(!permission.getAdmin().equals(admin)) {
//            return;
//        }
////        isGrand = false;
//        permission.setGrand(false);
////        isUnixPermissionGranted = false;
//        permission.setUnixPermissionGranted(false);
////        state = DENIED;
//        permission.setState(PermissionState.DENIED);
//        permission.notifyAdminOfPermissionResult();
//    }

    abstract void grantedBy(SystemAdmin admin,SystemPermission permission);

//    public void grantedBy(SystemAdmin admin,SystemPermission permission) {
//        if(!permission.getState().equals(PermissionState.CLAIMED) && !permission.getState().equals(PermissionState.UNIX_CLAIMED)) {
//            return;
//        }
//        if(permission.getAdmin().equals(admin)) {
//            return;
//        }
//        if(permission.getProfile().isUnixPermissionRequired() && permission.getState().equals(PermissionState.UNIX_CLAIMED)) {
//            permission.setUnixPermissionGranted(true);
//        } else if(permission.getProfile().isUnixPermissionRequired() && !permission.isUnixPermissionGranted()) {
////            state = UNIX_CLAIMED;
//            permission.setState(PermissionState.UNIX_CLAIMED);
//            permission.notifyAdminOfPermissionRequest();
//            return;
//        }
////        state = GRANTED;
//        permission.setState(PermissionState.GRANTED);
////        isGrand =true;
//        permission.setGrand(true);
//        permission.notifyAdminOfPermissionResult();
//    }



}
