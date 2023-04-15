package martinfowler.chapter08rfc;

import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Pattern;

/**
 *
 */
public class IntervalWindow extends Frame implements Observer {

    TextField startField;
    TextField endField;
    TextField lengthField;
    // 2. 在GUI类IntervalWindow中加入领域类属性
    private Interval subject;

    public IntervalWindow() {
        this.startField = new TextField();
        this.endField = new TextField();
        this.lengthField = new TextField();

        SymFocus focusListener = new SymFocus();
        startField.addFocusListener(focusListener);
        endField.addFocusListener(focusListener);
        lengthField.addFocusListener(focusListener);

        // 3. 合理的初始化subject字段
        subject = new Interval();
        // 4. 把IntervalWindow变成Interval的一个Observer,此时说明IntervalWindow必须是一个Observer，他要实现Observer
        subject.addObserver(this);
        // 5. 保证当我们把数据复制到领域类后，GUI将根据领域类进行初始化
        update(subject, null);
    }

    // 9. 修改update方法，确保GUI对Interval对象发来的通告做出响应
    @Override
    public void update(Observable o, Object arg) {
        //从领域类中获取数据
        endField.setText(subject.getEnd());
        startField.setText(subject.getStart());
        lengthField.setText(subject.getLength());
    }

    // 6. 文本框的更新是通过getText()和setText(),因此我们所建立的访问函数需要调用这两个函数
    // 7. 修改所有的引用点为访问函数
    String getEnd() {
        return subject.getEnd();
    }

    void setEnd(String arg) {
        subject.setEnd(arg);
    }

    String getStart() {
        return subject.getStart();
    }

    void setStart(String arg) {
        subject.setStart(arg);
    }

    String getLength() {
        return subject.getLength();
    }

    void setLength(String arg) {
        subject.setLength(arg);
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
            // 7.1 取保用户输入都是通过设值函数
            setStart(startField.getText());
            if (isNotInteger(startField.getText())) {
                startField.setText("0");
            }
            subject.calculateLength();
        }

        void EndField_FocusLost(FocusEvent event) {
            // 7.2 取保用户输入都是通过设值函数
            setEnd(endField.getText());
            if(isNotInteger(endField.getText())) {
                endField.setText("0");
            }
            subject.calculateLength();
        }

        void LengthField_FocusLost(FocusEvent event) {
            if(isNotInteger(lengthField.getText())) {
                lengthField.setText("0");
            }
            subject.calculateEnd();
        }

        private boolean isNotInteger(String str) {
            if(StringUtils.isBlank(str)) {
                return false;
            }
            Pattern pattern = Pattern.compile("^[+]{0,1}(\\d+)$");
            return !pattern.matcher(str).matches();
        }

    }

    public static void main(String[] args) {
        IntervalWindow intervalWindow = new IntervalWindow();
    }


}
