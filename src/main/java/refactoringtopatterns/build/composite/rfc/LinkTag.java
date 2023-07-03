package refactoringtopatterns.build.composite.rfc;

import java.util.Enumeration;

//2. 继承CompositeTag
public class LinkTag extends CompositeTag {



    //2.1 pulled-up field to CompositeTag
//    protected Vector nodeVector;

    public LinkTag(int tagBegin, int tagEnd, String tagContents, String tagLine) {
        super(tagBegin, tagEnd, tagContents, tagLine);
    }

    //4.此时LinkTag#LinkTag 和 FormTag#toPlainTextString 方法体是一样的，直接上移到CompositeTag
//    public String toPlainTextString() {
//        StringBuffer sb = new StringBuffer();
//        Node node;
//        for (Enumeration e = children(); e.hasMoreElements();) {
//            node = (Node)e.nextElement();
//            sb.append(node.toPlainTextString());
//        }
//        return sb.toString();
//    }

    public String toHTML() {
        StringBuffer sb = new StringBuffer();
        putLinkStartTagInto(sb);
        Node node;
        for(Enumeration e = children(); e.hasMoreElements();) {
            node = (Node)e.nextElement();
            sb.append(node.toHTML());
        }
        sb.append("</A>");
        return sb.toString();
    }




    // 3.1 该方法和 FormTag#getAllNodesVectors 逻辑上是一致的，提取到父类
//    public Enumeration linkData() {
//        return children.elements();
//    }





}
