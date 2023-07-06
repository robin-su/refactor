package refactoringtopatterns.build.observer;

import org.junit.Test;

public class UITestResult extends TestResult {

    private TestRunner fRunner;

    public UITestResult(TestRunner fRunner) {
        this.fRunner = fRunner;
    }

    public synchronized void addFailure(Test test,Throwable t) {
        super.addFailure(test, t);
        fRunner = fRunner.addFailure(this, test, t);
    }

    public void endTest(Test test) {
        fRunner.endTest(this, test);
    }


}
