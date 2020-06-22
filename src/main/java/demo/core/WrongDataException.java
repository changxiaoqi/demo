package demo.core;

/**
 * Created by xingshaofei on 2017/10/19.
 * <p>
 * 错误数据异常，通常是指数据库有错误数据
 * <br>不要用于代替IllegalArgumentException，NullPointerException等异常类
 * </p>
 */
public class WrongDataException extends RuntimeException {
    public WrongDataException() {
    }

    public WrongDataException(String message) {
        super(message);
    }

    public WrongDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
