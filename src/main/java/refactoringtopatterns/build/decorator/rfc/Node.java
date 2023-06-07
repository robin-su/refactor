package refactoringtopatterns.build.decorator.rfc;

public interface Node {

    String toHtml();
    String toPlainTextString();

    //1.添加被包装接口StringNode的两个方法：getText和setText
    String getText();

    void setText(String text);
}
