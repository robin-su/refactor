package refactoringtopatterns.build.observer;

import org.junit.Test;

public class TextTestResult extends TestResult {

    @Override
    public synchronized void addError(Test test, Throwable t) {
        super.addError(test, t);
        System.out.println("E");
    }

    @Override
    protected void addFailure(Test test, Throwable t) {
        super.addFailure(test, t);
        System.out.println("F");
    }

    public synchronized void startTest(Test test) {
        super.startTest(test);
        System.out.println("G");
    }

}
