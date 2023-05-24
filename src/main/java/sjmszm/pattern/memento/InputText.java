package sjmszm.pattern.memento;

public class InputText {

    private StringBuilder text = new StringBuilder();

    public String getText() {
        return text.toString();
    }

    public void append(String input) {
        text.append(input);
    }

    /**
     * 第一，为了能用快照恢复 InputText 对象，我们在 InputText 类中定义了 setText() 函数，
     * 但这个函数有可能会被其他业务使用，所以，暴露不应该暴露的函数违背了封装原则；
     *
     * 第二，快照本身是不可变的，理论上讲，不应该包含任何 set() 等修改内部状态的函数，但在上面的代码实现中，“快照“这个业务模型复用了
     * InputText 类的定义，而 InputText 类本身有一系列修改内部状态的函数，所以，用 InputText 类来表示快照违背了封装原则。
     *
     * @param text
     */
    public void setText(String text) {
        this.text.replace(0, this.text.length(),text);
    }

}
