package com.admin.controller;


import com.admin.entity.Response;
import com.admin.mapper.LoanMapper;
import com.admin.mapper.MarketingMapper;
import com.admin.mapper.RepayMapper;
import com.admin.service.MarketingService;
import com.admin.service.RepayService;
import com.admin.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Api(tags = "RepayController", description = "还款模板")
@RestController
@RequestMapping(value = "/repay", produces = "application/json; charset=utf-8")
public class RepayController {
    private static final Logger logger = LoggerFactory.getLogger(RepayController.class);
    @Autowired
    RepayService repayService;
    @Autowired
    RepayMapper repayMapper;

    @ApiModelProperty(value = "推广模板列表", notes = "推广模板列表")
    @ApiResponse(code = 200, message = "统一下单")
    @GetMapping("/list")
    @ResponseBody
    public Response list(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
//        logger.info("page====>" + page + " limit====>" + limit);
        return ResponseUtil.getResponse(repayService.getRepayList(page, limit));
    }

    @ApiModelProperty(value = "推广模板列表", notes = "推广模板列表")
    @ApiResponse(code = 200, message = "统一下单")
    @RequestMapping("/detail")
    @ResponseBody
    public Response detail(@RequestParam("repayId") int repayId) {
        return ResponseUtil.getResponse(repayMapper.selectByPrimaryKey(repayId));
    }

    @ApiModelProperty(value = "更新模板", notes = "更新模板")
    @ApiResponse(code = 200, message = "统一下单")
    @RequestMapping("/update")
    @ResponseBody
    public Response update(@RequestBody String req) {
        return ResponseUtil.getResponse(repayService.update(req));
    }
}
