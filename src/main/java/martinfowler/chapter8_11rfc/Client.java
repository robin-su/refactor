package martinfowler.chapter8_11rfc;

import junit.framework.Assert;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Client {

    public static void main(String[] args) {
        Person kent = new Person();
        /**
         * 5.不能将出入的Set直接赋值给course字段，万一用户把Set传递给Person之后又去修改Set中的元素，
         * 就会破坏封装。
         */
//        Set<Course> s = new HashSet<>();
//        s.add(new Course("Smalltalk Programming",false));
//        s.add(new Course("Appreciating Single Malts", true));
//        kent.initializeCourses(s);
        kent.addCourse(new Course("Smalltalk Programming",false));
        kent.addCourse(new Course("Appreciating Single Malts", true));

        Assert.assertEquals(2,kent.numberOfCourses());


        Course refact = new Course("Refactoring", true);
        // 6.修改"通过取值函数修改集合的元素"的情况
        // 6.1
//        kent.getCourses().add(refact);
        kent.addCourse(refact);
        // 6.2
//        kent.getCourses().add(new Course("Brutal Sarcasm",false));
        kent.addCourse(new Course("Brutal Sarcasm",false));
        Assert.assertEquals(4,kent.numberOfCourses());
        // 6.3
//        kent.getCourses().remove(refact);
        kent.removeCourse(refact);
        Assert.assertEquals(3,kent.numberOfCourses());

        // 8.观察取值函数的用户，从中找出应该属于Person的代码。搬移过去
        int count = kent.numberOfAdvancedCourses();

        System.out.println("Advanced courses:" + count);
    }


}
