package refactoringtopatterns.build.observer.rfc;

import org.junit.Test;

/**
 * 1.搬移方法重构，使TextTestResult只包含单纯的通知方法，并把定制行为搬移到相应的TestRunner当中
 */
/* 6. 删除 TextTestResult 和 UITestResult
public class TextTestResult extends TestResult {

    *//**
     * 2.现在开始抽取观察者：TestListener
     * 2.1 找出TextTestResult类调用了TestRunner的哪些方法，本例中是：
     *      testRunner.addError(this, test, t)、
     *      testRunner.addFailure(this, test,t)、
     *      testRunner.startTest(this, test)
     * 将这些方法提炼到 TestListener 接口
     *//*
    //1.2
    private TestRunner testRunner;

    //1.3
    public TextTestResult(TestRunner testRunner) {
        this.testRunner = testRunner;
    }

    @Override
    public synchronized void addError(Test test, Throwable t) {
        super.addError(test, t);
//        System.out.println("E"); // 定制行为
        //1.4
        testRunner.addError(this, test, t);
    }

    @Override
    protected void addFailure(Test test, Throwable t) {
        super.addFailure(test, t);
//        System.out.println("F");
        testRunner.addFailure(this, test,t);
    }

    public synchronized void startTest(Test test) {
        super.startTest(test);
//        System.out.println("G");
        testRunner.startTest(this, test);
    }

}*/
