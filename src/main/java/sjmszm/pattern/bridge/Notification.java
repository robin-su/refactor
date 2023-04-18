package sjmszm.pattern.bridge;

import junit.framework.Assert;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Notification {

    private List<String> emailAddress = new ArrayList<>();
    private List<String> telephones = new ArrayList<>();
    private List<String> wechatIds = new ArrayList<>();

    public Notification() {
    }

    public void setEmailAddress(List<String> arg) {
        Assert.assertTrue(emailAddress.isEmpty());
        emailAddress.addAll(arg);
    }

    public void setTelephones(List<String> arg) {
        Assert.assertTrue(emailAddress.isEmpty());
        telephones.addAll(arg);
    }

    public void setWechatIds(List<String> arg) {
        Assert.assertTrue(wechatIds.isEmpty());
        wechatIds.addAll(arg);
    }

    public List<String> getEmailAddress() {
        return Collections.unmodifiableList(emailAddress);
    }

    public List<String> getTelephones() {
        return Collections.unmodifiableList(telephones);
    }

    public List<String> getWechatIds() {
        return Collections.unmodifiableList(wechatIds);
    }

    void notify(NotificationEmergencyLevel level, String message) {
        // ...
        if(level.equals(NotificationEmergencyLevel.SEVERE)) {
            //...自动语音电话
        } else if (level.equals(NotificationEmergencyLevel.URGENCY)) {
            //...发微信
        } else if(level.equals(NotificationEmergencyLevel.NORMAL)) {
            //...发邮件
        } else if (level.equals(NotificationEmergencyLevel.TRIVIAL)) {
            //...发邮件
        }
    }

}
