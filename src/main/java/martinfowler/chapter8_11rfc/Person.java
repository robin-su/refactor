package martinfowler.chapter8_11rfc;

import junit.framework.Assert;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Person {

    // 2. 对集合进行初始化
    private Set<Course> courses = new HashSet<>();

    //7.修改取值函数，让他返回一个只读副本
    public Set<Course> getCourses() {
//        return courses;
        return Collections.unmodifiableSet(courses);
    }

    //3.如果许多地方大量运用了设置函数，我们就需要修改设值函数，令他调用添加/移除函数
    //3.1 设置函数主要有两个用途：用来初始化集合，也就是说他在被调用之前集合是空集合
    // setCourses就是典型的初始化集合，注意如果只是添加集合，并没有其他行为，应该去掉循环
    //4.修改函数名称，表明意图
    //5.移步到调用端Client
    public void initializeCourses(Set<Course> arg) {
        Assert.assertTrue(courses.isEmpty()); // 取保初始化之前courses是空的
        /**
         * 在有其他行为时，使用循环；没有其他行为时，使用集合全量增加
         * Iterator<Course> iter = arg.iterator();
         * while (iter.hasNext()) {
         *    addCourse(iter.next());
         * }
         */
        courses.addAll(arg);
    }

    // 1. 在Person类中建立合适的修改函数【添加/移除】
    public void addCourse(Course arg) {
        this.courses.add(arg);
    }

    public void removeCourse(Course arg) {
        this.courses.remove(arg);
    }

    public int numberOfAdvancedCourses() {
        Iterator<Course> iter = getCourses().iterator();
        int count = 0;
        while (iter.hasNext()) {
            Course each = iter.next();
            if (each.isAdvanced()) {
                count++;
            }
        }
        return count;
    }

    public int numberOfCourses() {
        return courses.size();
    }

}
