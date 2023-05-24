package sjmszm.ratelimiter.mvp.exception;

/**
 * 1） 我们通常需要保证程序不会捕捉到不在我们预期范围内的异常，比如RuntimeException，我们希望这类异常是要往外抛，而不是在内部被捕获。
 *     不要让它把异常吞掉，因为一旦程序出现问题，没有异常信息很难定位。
 *
 * 2） 如果希望调用者能够从异常中进行合理恢复，需要设置为受检异常类型，如果调用者无法采用任何措施使得程序无法重异常中恢复，需要把该异常
 *     设置为非受检异常。
 * 3） 受检异常会强迫API的使用者截获异常并恢复处理，或者进行声明继续抛出。
 */
public class InternalErrorException extends Exception {

    public InternalErrorException(String message) {
        super(message);
    }

    public InternalErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
