package exception;

/**
 * @Author jxx
 * @create 2020/7/8 3:53 下午
 */

/**
 * 重复秒杀异常
 */
public class repeatShotException extends oneShotException{
    public repeatShotException(String message) {
        super(message);
    }

    public repeatShotException(String message, Throwable cause) {
        super(message, cause);
    }

}
