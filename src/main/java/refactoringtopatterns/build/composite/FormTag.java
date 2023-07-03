package refactoringtopatterns.build.composite;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class FormTag extends Tag {

    protected Vector allNodesVectors;
    private String formName;
    private String formURL;
    private static final String ACTION = "action";

    public FormTag(int tagBegin, int tagEnd, String tagContents, String tagLine) {
        super(tagBegin, tagEnd, tagContents, tagLine);
    }

    public String toPlainTextString() {
        StringBuffer stringRepresentation = new StringBuffer();
        Node node;
        for(Enumeration e=getAllNodesVectors().elements(); e.hasMoreElements();) {
            node = (Node)e.nextElement();
            stringRepresentation.append(node.toPlainTextString());
        }
        return stringRepresentation.toString();
    }

    public String toHTML() {
        StringBuffer rawBuffer = new StringBuffer();
        Node node,prevNode = null;
        rawBuffer.append("<FROM  METHOD=\"" + formName + "\" ACTION = \"" + formURL + "\"");
        if(formName != null && formName.length() > 0) {
            rawBuffer.append(" NAME=\"" + formName + "\"");
        }
        Enumeration e = allNodesVectors.elements();
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

    public Vector getAllNodesVectors() {
        return this.allNodesVectors;
    }

}
