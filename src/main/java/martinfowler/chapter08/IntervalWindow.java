package martinfowler.chapter08;

import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Pattern;

public class IntervalWindow extends Frame {

    TextField startField;
    TextField endField;
    TextField lengthField;

    public IntervalWindow() {
        this.startField = new TextField();
        this.endField = new TextField();
        this.lengthField = new TextField();

        SymFocus focusListener = new SymFocus();
        startField.addFocusListener(focusListener);
        endField.addFocusListener(focusListener);
        lengthField.addFocusListener(focusListener);
    }

    class SymFocus extends FocusAdapter {

        public void focusLost(FocusEvent event) {
            Object object = event.getSource();
            if(object == startField) {
                StartField_FocusLost(event);
            } else if(object == endField) {
                EndField_FocusLost(event);
            } else if(object == lengthField) {
                LengthField_FocusLost(event);
            }
        }

        void StartField_FocusLost(FocusEvent event) {
            if (isNotInteger(startField.getText())) {
                startField.setText("0");
            }
            calculateLength();
        }

        void EndField_FocusLost(FocusEvent event) {
            if(isNotInteger(endField.getText())) {
                endField.setText("0");
            }
            calculateLength();
        }

        void LengthField_FocusLost(FocusEvent event) {
            if(isNotInteger(lengthField.getText())) {
                lengthField.setText("0");
            }
            calculateEnd();
        }

        void calculateLength() {
            try {
                int start = Integer.parseInt(startField.getText());
                int end = Integer.parseInt(endField.getText());
                int length = end - start;
                lengthField.setText(String.valueOf(length));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Unexcepted Number Format Error:%s");
            }
        }

        void calculateEnd() {
            try {
                int start = Integer.parseInt(startField.getText());
                int length = Integer.parseInt(lengthField.getText());
                int end = start + length;
                lengthField.setText(String.valueOf(end));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Unexcepted Number Format Error:%s");
            }
        }

        private boolean isNotInteger(String str) {
            if(StringUtils.isBlank(str)) {
                return false;
            }
            Pattern pattern = Pattern.compile("^[+]{0,1}(\\d+)$");
            return !pattern.matcher(str).matches();
        }

    }


}
