package refactoringtopatterns.build.composite.rfc;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 1. 创建一个组合Composite,将子类中重复的代码提取出来
 */
public abstract class CompositeTag extends Tag {

    //2.1 pulled-up field to CompositeTag
    //2.4 重命名为children使其更加合理
    protected Vector children;

    public CompositeTag(int tagBegin, int tagEnd, String tagContents, String tagLine) {
        super(tagBegin, tagEnd, tagContents, tagLine);
    }

    // 3.1 该方法和 FormTag#getAllNodesVectors 逻辑上是一致的，提取到父类
    //3.2 重命名该方法使其更具通用型
    public Enumeration children() {
        return children.elements();
    }

    public String toPlainTextString() {
        StringBuffer sb = new StringBuffer();
        Node node;
        for (Enumeration e = children(); e.hasMoreElements(); ) {
            node = (Node) e.nextElement();
            sb.append(node.toPlainTextString());
        }
        return sb.toString();
    }

    public void putLinkStartTagInto(StringBuffer sb) {
//        sb.append("<A ");
        sb.append("< " + getName() + " ");
        String key, value;
        int i = 0;
        for (Enumeration e = parsed.keys(); e.hasMoreElements(); ) {
            key = (String) e.nextElement();
            i++;
            if (key != LinkTag.TAGNAME) {
                value = getParameter(key);
                sb.append(key + "=\"" + value + "\"");
                if (i < parsed.size() - 1) {
                    sb.append(" ");
                }
            }
        }
        sb.append(">");
    }

    public String getName() {
        return "A";
    }
}