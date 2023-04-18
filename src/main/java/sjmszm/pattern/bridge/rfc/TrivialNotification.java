package sjmszm.pattern.bridge.rfc;

public class TrivialNotification extends Notification{
    public TrivialNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.notify();
    }
}
