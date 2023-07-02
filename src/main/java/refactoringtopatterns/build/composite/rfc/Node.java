package refactoringtopatterns.build.composite;

public class Node {

    public String toPlainTextString() {
        return "I am just toPlainTextString test text";
    }

    public String toHTML() {
        return "I am just toHTML test text";
    }

    public int elementEnd() {
        return 1024;
    }

    public int elementBegin() {
        return 2048;
    }
}
