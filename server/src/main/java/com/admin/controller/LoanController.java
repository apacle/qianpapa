package com.admin.controller;


import com.admin.entity.Response;
import com.admin.mapper.LoanMapper;
import com.admin.mapper.MarketingMapper;
import com.admin.service.LoanService;
import com.admin.service.MarketingService;
import com.admin.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Api(tags = "LoanController", description = "还款模板")
@RestController
@RequestMapping(value = "/loan", produces = "application/json; charset=utf-8")
public class LoanController {
    private static final Logger logger = LoggerFactory.getLogger(LoanController.class);
    @Autowired
    LoanService loanService;
    @Autowired
    LoanMapper loanMapper;

    @ApiModelProperty(value = "推广模板列表", notes = "推广模板列表")
    @ApiResponse(code = 200, message = "统一下单")
    @GetMapping("/list")
    @ResponseBody
    public Response list(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
        logger.info("page====>" + page + " limit====>" + limit);
        return ResponseUtil.getResponse(loanService.getLoanList(page, limit));
    }

    @ApiModelProperty(value = "推广模板列表", notes = "推广模板列表")
    @ApiResponse(code = 200, message = "统一下单")
    @RequestMapping("/detail")
    @ResponseBody
    public Response detail(@RequestParam("loanId") int loanId) {
        return ResponseUtil.getResponse(loanMapper.selectByPrimaryKey(loanId));
    }

    @ApiModelProperty(value = "更新模板", notes = "更新模板")
    @ApiResponse(code = 200, message = "统一下单")
    @RequestMapping("/update")
    @ResponseBody
    public Response update(@RequestBody String req) {
        return loanService.update(req);
    }
}
