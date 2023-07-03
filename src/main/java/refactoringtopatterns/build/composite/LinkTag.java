package refactoringtopatterns.build.composite;

import java.util.Enumeration;
import java.util.Vector;

public class LinkTag extends Tag {

    protected Vector nodeVector;

    private static final String TAGNAME = "tagName";

    public LinkTag(int tagBegin, int tagEnd, String tagContents, String tagLine) {
        super(tagBegin, tagEnd, tagContents, tagLine);
    }

    public String toPlainTextString() {
        StringBuffer sb = new StringBuffer();
        Node node;

        for (Enumeration e = linkData(); e.hasMoreElements();) {
            node = (Node)e.nextElement();
            sb.append(node.toPlainTextString());
        }
        return sb.toString();
    }

    public Enumeration linkData() {
        return nodeVector.elements();
    }

    public String toHTML() {
        StringBuffer sb = new StringBuffer();
        putLinkStartTagInto(sb);
        Node node;
        for(Enumeration e = linkData(); e.hasMoreElements();) {
            node = (Node)e.nextElement();
            sb.append(node.toHTML());
        }
        sb.append("</A>");
        return sb.toString();
    }

    public void putLinkStartTagInto(StringBuffer sb) {
        sb.append("</A ");
        String key,value;
        int i = 0;
        for(Enumeration e = parsed.keys();e.hasMoreElements();) {
            key = (String)e.nextElement();
            i++;
            if(key != TAGNAME) {
                value = getParameter(key);
                sb.append(key + "=\"" + value + "\"");
                if(i < parsed.size() - 1) {
                    sb.append(" ");
                }
            }
        }
        sb.append(">");
    }

    public String getParameter(String key) {
        return "test";
    }


}
