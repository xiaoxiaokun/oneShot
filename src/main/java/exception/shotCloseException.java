package exception;

/**
 * @Author jxx
 * @create 2020/7/8 3:55 下午
 */

/**
 * ，秒杀关闭异常
 */
public class shotCloseException extends oneShotException{
    public shotCloseException(String message) {
        super(message);
    }

    public shotCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
