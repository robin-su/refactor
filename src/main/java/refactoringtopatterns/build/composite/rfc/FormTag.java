package refactoringtopatterns.build.composite.rfc;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

//2.继承到CompositeTag
public class FormTag extends CompositeTag {
    //2.1 修改名字和Pulled-up field的保持一致
//    protected Vector allNodesVectors;
    //2.2 删除本地变量，使用Pulled-up到父类的变量
//    private Vector nodeVector;
    private String formName;
    private String formURL;
    private static final String ACTION = "action";

    public FormTag(int tagBegin, int tagEnd, String tagContents, String tagLine) {
        super(tagBegin, tagEnd, tagContents, tagLine);
    }

    //4.2
//    public String toPlainTextString() {
//        StringBuffer stringRepresentation = new StringBuffer();
//        Node node;
////        for(Enumeration e=getAllNodesVectors().elements(); e.hasMoreElements();) {
//        for(Enumeration e = children(); e.hasMoreElements();) {
//            node = (Node)e.nextElement();
//            stringRepresentation.append(node.toPlainTextString());
//        }
//        return stringRepresentation.toString();
//    }


    public String toHTML() {
        StringBuffer rawBuffer = new StringBuffer();
        Node node,prevNode = null;
        rawBuffer.append("<FROM  METHOD=\"" + formName + "\" ACTION = \"" + formURL + "\"");
        if(formName != null && formName.length() > 0) {
            rawBuffer.append(" NAME=\"" + formName + "\"");
        }
        Enumeration e = children();
        node = (Node)e.nextElement();
        Tag tag = (Tag)node;
        Hashtable table = tag.getParsed();
        String key,value;
        for(Enumeration en = table.keys();  en.hasMoreElements();) {
            key = (String)en.nextElement();
            if(! key.equals("METHOD")
             || key.equals("ACTION")
             || key.equals("NAME")
             || key.equals(Tag.TAGNAME)) {
                value = (String)table.get(key);
                rawBuffer.append(" " + key + "=" + "\"" + value +"\"");
            }
        }

        rawBuffer.append(">");
        rawBuffer.append(lineSeparator);
        for (;e.hasMoreElements();) {
            node = (Node)e.nextElement();
            if(prevNode != null) {
                if(prevNode.elementEnd() > node.elementBegin()) {
                    // It's a new line
                    rawBuffer.append(node.toHTML());
                    prevNode = node;
                }
            }
        }
        return rawBuffer.toString();

    }

    // 3.3 该方法和 LinkTag#getAllNodesVectors 重复，直接删除
//    public Vector getAllNodesVectors() {
//        return this.children;
//    }

}
