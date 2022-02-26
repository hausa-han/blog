package cn.hausahan.blog.common.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResult implements Serializable{
    private int code;
    private String msg;
    private Object data;

    public static BaseResult success(Object data){
        return success(200, "success", data);
    }
    public static BaseResult success(int code, String msg, Object data){
        BaseResult result = new BaseResult();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static BaseResult fail(String msg){
        Object failObject = new Object();
        return fail(400, msg, failObject);
    }
    public static BaseResult fail(String msg, Object data){
        return fail(400, msg, data);
    }
    public static BaseResult fail(int code, String msg, Object data){
        BaseResult result = new BaseResult();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
