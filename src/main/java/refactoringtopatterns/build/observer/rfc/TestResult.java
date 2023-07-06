package refactoringtopatterns.build.observer.rfc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * 4.上移 TestTestResult和 UITestResult中的方法，虽然这些方法已经存在与TestResult中,
 *   也就是将TestResult的子类代码合并到TestResult中
 */
public class TestResult {

    /** 7.新增观察者容器 */
    private List<TestListener> observers = new ArrayList<>();

    /** 7.1 提供一个观察者的注册方法 */
    public void addObserver(TestListener listener) {
        observers.add(listener);
    }

    /** 4.1 */
//    private  TestListener fRunner;

    /** 4.4 */
    private Vector fFailures;

    /** 4.5 */
    private Vector fErrors;

    private int fRuntest;

    private boolean fstop;

    /** 4.2 */
    public TestResult() {
        fFailures = new Vector(10);
        fErrors = new Vector(10);
        fRuntest = 0;
        fstop = false;
    }

    /** 4.3 */
//    public TestResult(TestListener runner) {
//        this();
//        this.fRunner = runner;
//    }

    /** 4.6 */
    protected synchronized void addError(Test test, Throwable t) {
        fErrors.addElement(new TestFailure(test, t));
        // 8 修改通知方法
        /*if(null != fRunner) {
            fRunner.addError(this, test, t);
        }*/
        for (Iterator<TestListener> i = observers.iterator(); i.hasNext();) {
            TestListener observer = i.next();
            observer.addError(this, test, t);
        }
    }

    /** 4.7 */
    protected void addFailure(Test test, Throwable t) {
        fFailures.addElement(new TestFailure(test, t));
        // 8 .1 修改通知方法
//        if(null != fRunner) {
//            fRunner.addFailure(this, test, t);
//        }

        for (Iterator<TestListener> i = observers.iterator(); i.hasNext();) {
            TestListener observer = i.next();
            observer.addFailure(this, test, t);
        }
    }

    /** 4.8 */
    public void endTest(Test test) {
//        if(null != fRunner) {
//            fRunner.endTest(this, test);
//        }
        //8.2
        for (Iterator<TestListener> i = observers.iterator(); i.hasNext();) {
            TestListener observer = i.next();
            observer.endTest(this, test);
        }
    }

    /** 4.9 */
    public synchronized void startTest(Test test) {
        fRuntest ++;
//        System.out.println("G");
//        if(null != fRunner) {
//            fRunner.startTest(this, test);
//        }

        //8.3
        for (Iterator<TestListener> i = observers.iterator(); i.hasNext();) {
            TestListener observer = i.next();
            observer.startTest(this, test);
        }
    }


}
