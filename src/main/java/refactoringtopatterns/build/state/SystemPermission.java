package refactoringtopatterns.build.state;

public class SystemPermission {

    private SystemProfile profile;
    private SystemUser systemUser;
    private SystemAdmin admin;

    private boolean isGrand;
    private boolean isUnixPermissionGranted;
    private String state;

    public final static String REQUIRED = "REQUIRED";
    public final static String CLAIMED = "CLAIMED";
    public final static String GRANTED = "GRANTED";
    public final static String DENIED = "DENIED";
    public final static String UNIX_REQUESTED = "UNIX_REQUESTED";
    public final static String UNIX_CLAIMED = "UNIX_CLAIMED";


    public SystemPermission(SystemUser systemUser,SystemProfile systemProfile) {
        this.profile = systemProfile;
        this.systemUser = systemUser;
        state = REQUIRED;
        isGrand = false;
        notifyAdminOfPermissionResult();
    }

    public void claimedBy(SystemAdmin admin) {
        if(!state.equals(REQUIRED) && !state.equals(UNIX_REQUESTED)) {
            return;
        }
        willBeHandledBy(admin);
        if(state.equals(REQUIRED)) {
            state = CLAIMED;
        } else if(state.equals(UNIX_REQUESTED)) {
            state = UNIX_CLAIMED;
        }
    }

    public void deniedBy(SystemAdmin admin) {
        if(!state.equals(CLAIMED) && !state.equals(UNIX_CLAIMED)) {
            return;
        }
        if(!this.admin.equals(admin)) {
            return;
        }
        isGrand = false;
        isUnixPermissionGranted = false;
        state = DENIED;
        notifyAdminOfPermissionResult();
    }

    public void grantedBy(SystemAdmin admin) {
        if(!state.equals(CLAIMED) && !state.equals(UNIX_CLAIMED)) {
            return;
        }
        if(this.admin.equals(admin)) {
            return;
        }
        if(profile.isUnixPermissionRequired() && state.equals(UNIX_CLAIMED)) {
            isUnixPermissionGranted = true;
        } else if(profile.isUnixPermissionRequired() && !isUnixPermissionGranted()) {
            state = UNIX_CLAIMED;
            notifyAdminOfPermissionRequest();
            return;
        }
        state = GRANTED;
        isGrand =true;
        notifyAdminOfPermissionResult();
    }

    public boolean isUnixPermissionGranted() {
        return this.isUnixPermissionGranted;
    }

    private void willBeHandledBy(SystemAdmin admin) {
    }

    private void notifyAdminOfPermissionRequest() {
    }

    private void notifyAdminOfPermissionResult() {
    }
}
