package refactoringtopatterns.build.observer.rfc;

import org.junit.Test;

/**
 * 2.2
 */
public interface TestListener {

    void addError(TestResult testResult, Test test, Throwable t);

    void addFailure(TestResult testResult,Test test, Throwable t);

    void startTest(TestResult testResult,Test test);

    void endTest(TestResult testResult,Test test);
}
