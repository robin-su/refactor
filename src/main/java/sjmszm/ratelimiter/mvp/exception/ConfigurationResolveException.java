package sjmszm.ratelimiter.mvp.exception;

public class ConfigurationResolveException extends RuntimeException {

    public ConfigurationResolveException(String message) {
        super(message);
    }

    public ConfigurationResolveException(String message, Throwable cause) {
        super(message, cause);
    }
}
