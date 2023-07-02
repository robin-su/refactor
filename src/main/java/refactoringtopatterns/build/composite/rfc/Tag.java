package refactoringtopatterns.build.composite;

import java.util.Hashtable;

public class Tag extends Node {
    protected static String TAGNAME;

    private int tagBegin;
    private int tagEnd;
    private String tagContents;
    private String tagLine;

    public Tag(int tagBegin, int tagEnd, String tagContents, String tagLine) {
        this.tagBegin = tagBegin;
        this.tagEnd = tagEnd;
        this.tagContents = tagContents;
        this.tagLine = tagLine;
    }

    public static final String lineSeparator = System.lineSeparator();

    protected Hashtable parsed;

    public Hashtable getParsed() {
        return parsed;
    }
}
