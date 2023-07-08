package refactoringtopatterns.build.mutiVersionAdapter.exception;

public class QueryException extends Exception {

    public static final String LOGIN_FAILED = "LOGIN_FAILED";

    public QueryException() {
        super();
    }

    public QueryException(String message) {
        super(message);
    }

    public QueryException(String message, Throwable cause) {
        super(message, cause);
    }

    public QueryException(Throwable cause) {
        super(cause);
    }

    protected QueryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public QueryException(String loginFailed, String s, Throwable lfe) {
    }
}
