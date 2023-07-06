package refactoringtopatterns.build.observer;

import org.junit.Test;

import java.awt.*;

public class TestRunner extends Frame {

    private TestResult fTestResult;


    protected TestResult createTestResult() {
        return new UITestResult(this);
    }

    public synchronized void runSuite() {
        fTestResult = createTestResult();
    }

    public TestRunner addFailure(UITestResult uiTestResult, Test test, Throwable t) {
        return null;
    }

    public void endTest(UITestResult uiTestResult, Test test) {
        System.out.println("end test");
    }
}
