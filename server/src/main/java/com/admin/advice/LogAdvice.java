package com.admin.advice;

import javax.servlet.http.HttpServletRequest;

import com.admin.enums.ResponseEnum;
import com.admin.util.JwtUtil;
import com.admin.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Component
@Aspect
//@Slf4j
public class LogAdvice {
    private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);

    @Pointcut("execution(* com.admin.controller.*.*(..))")
    private void anyMethod() {

    }

    @Around("anyMethod()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String token = httpServletRequest.getHeader("X-Token");
        String requestUrl = httpServletRequest.getRequestURI();
        logger.info("token:" + token);
        logger.info("请求地址:" + requestUrl);

        if (requestUrl.indexOf("/login") == -1 && null != token && null == JwtUtil.getUserId(token)) {
            return ResponseUtil.getResponse(ResponseEnum.FAIL.getCode(), "非法会话，请重新登陆！");
        }
        Object[] args = pjp.getArgs();

        Object result = null;
        if (args.length > 0)
            logger.info(args[0].toString());
        result = pjp.proceed(args);

        logger.info("响应:" + JSONObject.fromObject(result).toString());
        return result;
    }

}
