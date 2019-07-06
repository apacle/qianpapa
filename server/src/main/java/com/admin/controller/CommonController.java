package com.admin.controller;


import com.admin.entity.Response;
import com.admin.entity.User;
import com.admin.enums.ResponseEnum;
import com.admin.mapper.UserMapper;
import com.admin.service.UserService;
import com.admin.util.JwtUtil;
import com.admin.util.QRCodeUtil;
import com.admin.util.QrCodeUtils;
import com.admin.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiResponse;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;


@Api(tags = "CommonController", description = "用户接口")
@RestController
@RequestMapping(value = "/common", produces = "application/json; charset=utf-8")
public class CommonController {
    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    /**
     * 二维码
     */
    @RequestMapping("/qrcode")
    public void qrcode(@RequestParam("url") String url, @RequestParam("icon") String icon) {
        try {
            HttpServletResponse httpServletResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getResponse();

            OutputStream outputStream = httpServletResponse.getOutputStream();

            httpServletResponse.setHeader("Content-Disposition", "attachment;filename=" + DigestUtils.md5Hex(url.getBytes("UTF-8")) + ".jpg");
//            if (StringUtils.isEmpty(icon)) {
//                QrCodeUtils.encode(url, null, outputStream, true);
//            } else {
            QrCodeUtils.encode(url, icon, outputStream, true);
//            }
        } catch (Exception e) {
            logger.error("Common qrcode()", e);
        }
    }

}
