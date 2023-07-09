package refactoringtopatterns.build.interceptor.rfc;

public enum ProductSize {

    SMALL(1),
    MEDIUM(2),
    LARGE(3),
    NOT_APPLICABLE(4);

    private int size;

    ProductSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
