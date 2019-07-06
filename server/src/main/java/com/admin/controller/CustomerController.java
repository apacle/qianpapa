package com.admin.controller;


import com.admin.config.Constants;
import com.admin.entity.Customer;
import com.admin.entity.CustomerExample;
import com.admin.entity.Response;
import com.admin.entity.User;
import com.admin.mapper.CustomerMapper;
import com.admin.mapper.UserMapper;
import com.admin.service.CustomerService;
import com.admin.service.UserService;
import com.admin.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api(tags = "CustomerController", description = "客户")
@RestController
@RequestMapping(value = "/customer", produces = "application/json; charset=utf-8")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    UserService userService;
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerMapper customerMapper;

    @ApiModelProperty(value = "客户列表", notes = "客户列表")
    @ApiResponse(code = 200, message = "客户列表")
    @GetMapping("/list")
    @ResponseBody
    public Response list(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        logger.info("page====>" + page + " limit====>" + limit);
        return ResponseUtil.getResponse(customerService.getCustomerList(page, limit));
    }


    @ApiModelProperty(value = "统一下单接口", notes = "统一下单")
    @ApiResponse(code = 200, message = "统一下单")
    @RequestMapping("/register")
    public Response register(@RequestParam Map<String, String> map) {
        logger.info("req====>" + map);
        return customerService.register(map);
    }

    @ApiModelProperty(value = "推广模板列表", notes = "推广模板列表")
    @ApiResponse(code = 200, message = "统一下单")
    @RequestMapping("/detail")
    @ResponseBody
    public Response detail(@RequestParam("customerId") int customerId) {
        return ResponseUtil.getResponse(customerMapper.selectByPrimaryKey(customerId));
    }

    @ApiModelProperty(value = "更新模板", notes = "更新模板")
    @ApiResponse(code = 200, message = "统一下单")
    @RequestMapping("/update")
    @ResponseBody
    public Response update(@RequestBody String req) {
        return ResponseUtil.getResponse(customerService.update(req));
    }
}
