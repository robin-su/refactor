package martinfowler.chapter8_11rfc;

public class Course {

    private String name;
    private boolean isAdvanced;

    public Course(String name,boolean isAdvanced) {
        this.name = name;
        this.isAdvanced = isAdvanced;
    }

    public boolean isAdvanced() {
        return isAdvanced;
    }

}
