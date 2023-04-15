package martinfowler.chapter8_11;

import java.util.Set;

public class Person {

    private Set<Course> courses;

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
