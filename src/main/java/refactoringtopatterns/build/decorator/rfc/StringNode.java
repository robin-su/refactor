package refactoringtopatterns.build.decorator.rfc;

public class StringNode extends AbstractNode {

    //5.为类型码创建子类
    //6.1 去除shouldDecode类型码和设值函数，以及接收他的构造函数，只需要让shouldDecode()方法返回false就可以了
//    private boolean shouldDecode = false;
    private boolean shouldRemoveEscapeCharacters = false;
    protected StringBuffer textBuffer;

    private String text;


    private StringNode(StringBuffer textBuffer,
                      int textBegin,
                      int textEnd,
                      boolean shouldRemoveEscapeCharacters){
        this(textBuffer, textBegin,textEnd);
        this.shouldRemoveEscapeCharacters = shouldRemoveEscapeCharacters;
    }


    //4.1 将构造器改成私有
    //6.2 去除shouldDecode类型码和设值函数，以及接收他的构造函数，只需要让shouldDecode()方法返回false就可以了
//    private StringNode(StringBuffer textBuffer, int textBegin, int textEnd, boolean shouldDecode) {
//        this(textBuffer,textBegin,textEnd);
//        // 3.3 赋值函数改成设值函数
////        this.shouldDecode = shouldDecode;
//        setShouldDecode(shouldDecode);
//    }

    //4.2 创建Create Method,注意返回Node
    // 5.3 修改Create Method,使其能够根据类型码shouldDecode来创建适当的对象
    public static Node createStringNode(StringBuffer textBuffer,
                                 int textBegin,
                                 int textEnd,
                                 boolean shouldDecode) {
        if(shouldDecode) {
            // 10.6 此时DecodingNode不再继承与Node，应该让DecodingNode实现Node
            return new DecodingNode(textBuffer,textBegin,textEnd);
        }
        return new StringNode(textBuffer, textBegin, textEnd);
    }


    public StringNode(StringBuffer textBuffer,
                      int textBegin,
                      int textEnd) {
        super(textBegin,textEnd);
        this.textBuffer = textBuffer;
    }

    //3.1 对shouldDecode进行自封装
    //6.3 去除shouldDecode类型码和设值函数，以及接收他的构造函数，只需要让shouldDecode()方法返回false就可以了
    /*private void setShouldDecode(boolean shouldDecode) {
        this.shouldDecode = shouldDecode;
    }*/

    //3.2 对shouldDecode进行自封装
    // 5.1 将类型码的设值函数权限修改成protect,由于只有true和false,自己处理fase的情况
    // 8.1 删除StringNode和DecodingNode中的shouldDecode
//    protected boolean shouldDecode() {
//        return false;
//    }

    @Override
    public String toHtml() {
        return null;
    }

    // 7.1 将类型码相关的判断逻辑去除，属于子类行的将其移动到子类中去
    @Override
    public String toPlainTextString() {
        String result = this.textBuffer.toString();
//        if(this.shouldDecode) {
//            result = Translate.decode(result);
//        }

        if(this.shouldRemoveEscapeCharacters) {
            result = ParserUtils.removeEscapeCharacters(result);
        }
        return result;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
