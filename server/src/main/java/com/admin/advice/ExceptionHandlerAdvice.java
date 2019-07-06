//package com.admin.advice;
//
//import com.vue.VueException;
//import com.vue.constant.Constants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
//
//import lombok.extern.slf4j.Slf4j;
//import net.sf.json.JSONObject;
//
//@ControllerAdvice
//@RestController
//@Slf4j
//public class ExceptionHandlerAdvice {
//    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);
//
//    @ExceptionHandler(value = {VueException.class})
//    public Object handleErrors(VueException e) {
//        logger.error("VueExceptionHandlerAdvice", e);
//        JSONObject errorResult = new JSONObject();
//        errorResult.put("code", e.getCode());
//        errorResult.put("msg", e.getMsg());
//        return errorResult;
//    }
//
//    @ExceptionHandler(value = {Exception.class})
//    public Object handleErrors(Exception e) {
//        logger.error("ExceptionHandlerAdvice", e);
//        JSONObject errorResult = new JSONObject();
//        errorResult.put("code", Constants.CODE_FAIL);
//        errorResult.put("msg", null == e.getCause() ? e.getMessage() : e.getCause().getMessage());
//        return errorResult;
//    }
//}
