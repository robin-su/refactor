package refactoringtopatterns.build.factory.parser;

public class Parser {

    private Boolean shouldDecode;
    private boolean shouldRemoveEscapeCharacters;

    public Boolean shouldDecode() {
        return shouldDecode;
    }

    public void setShouldDecode(Boolean shouldDecode) {
        this.shouldDecode = shouldDecode;
    }

    public boolean shouldRemoveEscapeCharacters() {
        return shouldRemoveEscapeCharacters;
    }

    public void setShouldRemoveEscapeCharacters(boolean shouldRemoveEscapeCharacters) {
        this.shouldRemoveEscapeCharacters = shouldRemoveEscapeCharacters;
    }
}

