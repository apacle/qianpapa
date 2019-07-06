package com.admin.enums;

/**
 * web 层返回信息枚举
 *
 * @author qiaokun
 * @2018/08/13
 */
public enum ResponseEnum {
    /**
     * API调用成功返回
     */
    SUCCESS(10000, "请求成功"),
    FAIL(10001, "请求失败");
//    LOGIN_FAIL(10099, "登陆失败"),
//    AUTH_ERROR(10100, "认证失败");

    private int code = 0;

    private String msg;

    private ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
