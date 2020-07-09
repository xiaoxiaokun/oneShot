package exception;

/**
 * @Author jxx
 * @create 2020/7/8 3:56 下午
 */
public class oneShotException extends RuntimeException {
    public oneShotException(String message) {
        super(message);
    }

    public oneShotException(String message, Throwable cause) {
        super(message, cause);
    }
}
