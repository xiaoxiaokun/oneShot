package dto;

/**
 * @Author jxx
 * @create 2020/7/9 11:36 下午
 */

/**
 * ajax请求返回的类型，封装成json结果
 */
public class oneShotResult<T> {
    private boolean success;
    private T data;
    private String error;

    public oneShotResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public oneShotResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }
}
