package com.admin.util;

import com.admin.entity.Response;
import com.admin.enums.ResponseEnum;

/**
 * web层统一返回工具类
 *
 * @author qiaokun
 * @date 2018/07/18
 */
public class ResponseUtil {

    /**
     * 获取请求成功响应的Response
     *
     * @param data
     * @return
     */
    public static Response getResponse(Object data) {
        return getResponse(data, ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg());
    }

    /**
     * 获取其他请求响应的Response
     *
     * @param code
     * @param msg
     * @return
     */
    public static Response getResponse(int code, String msg) {
        return getResponse(null, code, msg);
    }

    /**
     * 枚举信息转统一返回对象
     *
     * @param ResponseEnum
     * @return
     */
    public static Response getResponse(ResponseEnum ResponseEnum) {
        return getResponse(ResponseEnum.getCode(), ResponseEnum.getMsg());
    }


    public static Response getResponse(Object data, int code, String msg) {
        Response Response = new Response(data);
        Response.setcode(code);
        Response.setmsg(msg);
        return Response;
    }


}
