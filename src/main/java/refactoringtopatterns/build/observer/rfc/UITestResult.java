package refactoringtopatterns.build.observer.rfc;

import org.junit.Test;

/* 6.2
public class UITestResult extends TestResult {

    //3. 修改TestRunner 为 TestListener
//    private TestRunner fRunner;
      // 3.1
//    public UITestResult(TestRunner fRunner) {
//        this.fRunner = fRunner;
//    }

    private TestListener fRunner;

    public UITestResult() {}

    // 3.2
    public UITestResult(TestListener runner) {
        this();
        this.fRunner = runner;
    }

    public synchronized void addFailure(Test test,Throwable t) {
        super.addFailure(test, t);
        fRunner.addFailure(this, test, t);
    }

    */
/**
     * 2.4 该方法在 TestListener 中没有，但是这个方法有调用了 TestRunner#endTest(this, test)，所以将其
     * 提炼到 TestListener 接口中
     *
     * @param test
     *//*

    public void endTest(Test test) {
        fRunner.endTest(this, test);
    }
}
*/
