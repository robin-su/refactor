package martinfowler.chapter8_11;

import junit.framework.Assert;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Client {

    public static void main(String[] args) {
        Person kent = new Person();
        Set<Course> s = new HashSet<>();
        s.add(new Course("Smalltalk Programming",false));
        s.add(new Course("Appreciating Single Malts", true));
        kent.setCourses(s); // 设置之后，后面又对集合s进行了修改
        Assert.assertEquals(2,kent.getCourses().size());


        Course refact = new Course("Refactoring", true);
        kent.getCourses().add(refact); // 就是这里以及下面对s进行了修改，封装性被破坏
        kent.getCourses().add(new Course("Brutal Sarcasm",false));

        Assert.assertEquals(4,kent.getCourses().size());
        kent.getCourses().remove(refact);
        Assert.assertEquals(3,kent.getCourses().size());

        Iterator<Course> iter = kent.getCourses().iterator();
        int count = 0;
        while (iter.hasNext()) {
            Course each = iter.next();
            if (each.isAdvanced()) {
                count++;
            }
        }

        System.out.println("Advanced courses:" + count);
    }
}
