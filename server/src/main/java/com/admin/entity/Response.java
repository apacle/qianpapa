package com.admin.entity;

import com.admin.enums.ResponseEnum;

/**
 * web层统一返回类型
 *
 * @author qiaokun
 * @date 2018/07/18
 */
public class Response {
    private int code = 0;

    private String msg;

    private Object data;

    public Response() {

    }


    public Response(Object data) {
        this.data = data;
    }

    public Response(ResponseEnum ResponseEnum) {
        this.code = ResponseEnum.getCode();
        this.msg = ResponseEnum.getMsg();
    }

    public int getcode() {
        return code;
    }

    public void setcode(int code) {
        this.code = code;
    }

    public String getmsg() {
        return msg;
    }

    public void setmsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
