package demo.core;



/**
 * Created by 李恒名 on 2017/6/13.
 * 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }

    public static Result genFailResult(ResultCode code, String message) {
        return new Result()
                .setCode(code)
                .setMessage(message);
    }

    public static Result genFailResult(ResultCode rc) {
        return new Result()
                .setCode(rc.code)
                .setMessage(rc.msg);
    }

    public static Result genResult(ResultCode rc) {
        return new Result()
                .setCode(rc.code)
                .setMessage(rc.msg);
    }

    public static Result genResultData(ResultCode rc, Object data) {
        return new Result()
                .setCode(rc.code)
                .setMessage(rc.msg)
                .setData(data);
    }

    public static Result genNoSessionResult() {
        return new Result()
                .setCode(ResultCode.NO_USER_SESSION.code)
                .setMessage(ResultCode.NO_USER_SESSION.msg);
    }

}
