package com.admin.controller;


import com.admin.entity.Marketing;
import com.admin.entity.Response;
import com.admin.mapper.MarketingMapper;
import com.admin.service.MarketingService;
import com.admin.util.JwtUtil;
import com.admin.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api(tags = "MarketingController", description = "推广模板")
@RestController
@RequestMapping(value = "/marketing", produces = "application/json; charset=utf-8")
public class MarketingController {
    private static final Logger logger = LoggerFactory.getLogger(MarketingController.class);
    @Autowired
    MarketingService marketingService;
    @Autowired
    MarketingMapper marketingMapper;

    @ApiModelProperty(value = "推广模板列表", notes = "推广模板列表")
    @ApiResponse(code = 200, message = "统一下单")
    @GetMapping("/list")
    @ResponseBody
    public Response list(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
//        logger.info("page====>" + page + " limit====>" + limit);
        return ResponseUtil.getResponse(marketingService.getMarketingList(page, limit));
    }

    @ApiModelProperty(value = "推广模板列表", notes = "推广模板列表")
    @ApiResponse(code = 200, message = "统一下单")
    @RequestMapping("/detail")
    @ResponseBody
    public Response detail(@RequestParam("marketingId") int marketingId) {
        return ResponseUtil.getResponse(marketingMapper.selectByPrimaryKey(marketingId));
    }

    @ApiModelProperty(value = "更新模板", notes = "更新模板")
    @ApiResponse(code = 200, message = "统一下单")
    @RequestMapping("/update")
    @ResponseBody
    public Response update(@RequestBody String req) {
        return ResponseUtil.getResponse(marketingService.update(req));
    }
}
