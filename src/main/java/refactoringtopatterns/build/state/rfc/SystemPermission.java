package refactoringtopatterns.build.state.rfc;

public class SystemPermission {

    private SystemProfile profile;
    private SystemUser systemUser;
    private SystemAdmin admin;

    private boolean isGrand;
    private boolean isUnixPermissionGranted;

    // 2.用类型为PermissionState
    private PermissionState state;


    public SystemPermission(SystemUser systemUser, SystemProfile systemProfile) {
        this.profile = systemProfile;
        this.systemUser = systemUser;
        setState(this.state);
        isGrand = false;
        notifyAdminOfPermissionResult();
    }

    // 2.1 用类型为PermissionState替代String state
    public void setState(PermissionState state) {
        this.state = state;
    }

    // 2.2 用类型为PermissionState替代String state
    public PermissionState getState() {
        return this.state;
    }

    // 2.3 用类型为PermissionState替代String state

    //4.1 将基于状态转换逻辑改变permission值的方法复制到PermissionState
    public void claimedBy(SystemAdmin admin) {
        state.claimedBy(admin, this);
    }


    // 2.4 用类型为PermissionState替代String state

    //4.2 将基于状态转换逻辑改变permission值的方法复制到PermissionState
    public void deniedBy(SystemAdmin admin) {
        state.deniedBy(admin,this);
    }

    public void setGrand(boolean grand) {
        isGrand = grand;
    }

    // 2.5 用类型为PermissionState替代String state

    //4.2 将基于状态转换逻辑改变permission值的方法复制到PermissionState
    public void grantedBy(SystemAdmin admin) {
        state.grantedBy(admin,this);
    }

    public void setUnixPermissionGranted(boolean unixPermissionGranted) {
        isUnixPermissionGranted = unixPermissionGranted;
    }


    public SystemAdmin getAdmin() {
        return admin;
    }

    public SystemProfile getProfile() {
        return profile;
    }

    public boolean isUnixPermissionGranted() {
        return this.isUnixPermissionGranted;
    }

    protected void willBeHandledBy(SystemAdmin admin) {
        this.admin = admin;
    }

    protected void notifyAdminOfPermissionRequest() {
    }

    protected void notifyAdminOfPermissionResult() {
    }
}
