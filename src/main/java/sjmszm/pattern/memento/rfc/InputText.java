package sjmszm.pattern.memento.rfc;

public class InputText {

    private StringBuilder text = new StringBuilder();

    public String getText() {
        return text.toString();
    }

    public void append(String input) {
        this.text.append(input);
    }

    public Snapshot createSnapshot() {
        return new Snapshot(this.text.toString());
    }

    public void restoreSnapshot(Snapshot snapshot) {
        this.text.replace(0,snapshot.getText().length(), snapshot.getText());
    }

}
