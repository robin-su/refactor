package refactoringtopatterns.build.observer;

import org.junit.Test;

public class TestFailure {

    private Test test;
    private Throwable t;

    public TestFailure(Test test, Throwable t) {
        this.test = test;
        this.t = t;
    }
}
