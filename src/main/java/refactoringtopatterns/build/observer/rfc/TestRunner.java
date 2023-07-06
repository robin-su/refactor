package refactoringtopatterns.build.observer.rfc;

import org.junit.Test;

import java.awt.*;

/**
 * 2.2 让 TestRunner 实现该接口 TestListener
 */
/** 5. 更新TestRunner实例，使其直接与TestResult交互 **/
public class TestRunner extends Frame implements TestListener {

    private TestResult fTestResult;

    // 9. 更新 TestRunner 实例子，使其使用新的addObserver方法，而不是调用 TestTesult的构造函数
    protected TestResult createTestResult() {
        // 5.1
//        return new UITestResult(this);
//        return new TestResult(this);
        TestResult testResult = new TestResult();
        testResult.addObserver(this);
        return testResult;
    }

    public synchronized void runSuite() {
        fTestResult = createTestResult();
    }

    /** 1.1 搬移定制行为 */
    public void addError(TestResult testResult,Test test, Throwable t) {
        System.out.println("E");
    }

    /** 1.5 */
    public void addFailure(TestResult testResult,Test test, Throwable t) {
        System.out.println("F");
    }

    public void startTest(TestResult testResult,Test test) {
        System.out.println("G");
    }

    /* 2.6 */
    @Override
    public void endTest(TestResult testResult, Test test) {

    }

}
