package com.admin.controller;


import com.admin.entity.Response;
import com.admin.enums.ResponseEnum;
import com.admin.mapper.UserMapper;
import com.admin.service.UserService;
import com.admin.entity.User;
import com.admin.util.ResponseUtil;
import com.admin.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiResponse;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Api(tags = "UserController", description = "用户接口")
@RestController
@RequestMapping(value = "/user", produces = "application/json; charset=utf-8")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    @ApiModelProperty(value = "统一下单接口", notes = "统一下单")
    @ApiResponse(code = 200, message = "统一下单")
    @PostMapping("/login")
    public Response login(@RequestBody String req) {
        logger.info("req====>" + req);
        JSONObject json = JSONObject.fromObject(req);
        String userName = json.getString("username");
        String password = json.getString("password");
        //身份验证是否成功
        User user = userService.getUserByName(userName);
        if (null == user) {
            return ResponseUtil.getResponse(ResponseEnum.FAIL.getCode(), "用户" + userName + "不存在!");
        }
        if (!password.equals(user.getUserPassword())) {
            return ResponseUtil.getResponse(ResponseEnum.FAIL.getCode(), "密码错误!");
        }
        //返回token
        String token = JwtUtil.sign(user.getUserName(), user.getUserId());
        if (token == null) {
            return ResponseUtil.getResponse(ResponseEnum.FAIL.getCode(), "生成Token失败!");
        }
        JSONObject data = new JSONObject();
        data.put("token", token);
        return ResponseUtil.getResponse(data);
    }


    @GetMapping(value = "/info")
    @ResponseBody
    public Response getUser(@RequestParam("token") String token) {
//        String userName = JwtUtil.getUserName(token);
        Integer userId = JwtUtil.getUserId(token);
        User user = this.userMapper.selectByPrimaryKey(userId);
        if (null != user) {
            JSONObject data = new JSONObject();
            data.put("roles", new String[]{user.getUserRole()});
            data.put("intro", user.getUserIntro());
            data.put("avatar", user.getUserAvater());
            data.put("name", user.getUserName());
            data.put("nickname", user.getUserNickname());
            data.put("email", user.getUserEmail());
            return ResponseUtil.getResponse(data);
        }
        //返回登陆失败消息
        return ResponseUtil.getResponse(ResponseEnum.FAIL);
    }

    @ApiModelProperty(value = "推广模板列表", notes = "推广模板列表")
    @ApiResponse(code = 200, message = "统一下单")
    @GetMapping("/list")
    @ResponseBody
    public Response list(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
        return ResponseUtil.getResponse(userService.getUserList(page, limit));
    }

    @ApiModelProperty(value = "推广模板列表", notes = "推广模板列表")
    @ApiResponse(code = 200, message = "统一下单")
    @RequestMapping("/detail")
    @ResponseBody
    public Response detail(@RequestParam("userId") int userId) {
        return ResponseUtil.getResponse(userMapper.selectByPrimaryKey(userId));
    }

    @ApiModelProperty(value = "更新用户信息", notes = "更新用户信息")
    @ApiResponse(code = 200, message = "更新用户信息")
    @PostMapping("/update")
    public Response update(@RequestBody String req, HttpServletRequest request) {
        logger.info("req====>" + req);
        //返回登陆失败消息
        return ResponseUtil.getResponse(userService.update(req));
    }
//transaction/list
//    {"code":20000,"data":{"total":20,"items":[{"order_no":"F1CC1faF-A851-ACf3-B8eC-d73bF93Cb13a","timestamp":1082477017209,"username":"Jose Young","price":13052.4,"status":"pending"},{"order_no":"5AA5FcDe-5285-4CBb-A12f-d8107f3EE612","timestamp":1082477017209,"username":"Eric Davis","price":12183.1,"status":"pending"},{"order_no":"2Ac58BBB-2568-d8Cb-b6d2-F840A8c6fcDf","timestamp":1082477017209,"username":"Kimberly Johnson","price":6020.3,"status":"pending"},{"order_no":"57713E4B-fFa0-7dBE-f98A-1FAC3DBc28E8","timestamp":1082477017209,"username":"Patricia Walker","price":2352.72,"status":"success"},{"order_no":"9DfDAF27-052c-7FAC-6EDe-DDf3bA79184e","timestamp":1082477017209,"username":"Ruth Brown","price":14727.1,"status":"pending"},{"order_no":"74Abe7CC-98c6-1593-D2c9-3Ca5Dc77efbc","timestamp":1082477017209,"username":"Deborah Taylor","price":2533.7,"status":"pending"},{"order_no":"1D5B46c7-50Bd-1F1B-9890-c1ACd4CdDeBf","timestamp":1082477017209,"username":"Barbara Smith","price":6243.04,"status":"pending"},{"order_no":"C37Ea2d7-84FA-b9Db-6DDE-f2B2B724fEEB","timestamp":1082477017209,"username":"Jason Lopez","price":7119.5,"status":"success"},{"order_no":"E18De72B-53Ec-E1F2-d9b6-b50fBBd7d3E2","timestamp":1082477017209,"username":"Kevin Lee","price":4884.42,"status":"success"},{"order_no":"4196A3aD-1fF9-4c6E-c99F-B62DB27c99E5","timestamp":1082477017209,"username":"Kevin Davis","price":13121,"status":"success"},{"order_no":"8c4ddA6D-6DCe-3FF4-dbb0-3BAB9DeeCe1c","timestamp":1082477017209,"username":"Richard Johnson","price":4495.7,"status":"success"},{"order_no":"077fbF3E-DE8f-d65F-86dA-93CcCdfe4eEb","timestamp":1082477017209,"username":"Susan Jones","price":6122,"status":"pending"},{"order_no":"D7DfF49E-12AC-6219-e3Aa-9ECd9BE3E4D8","timestamp":1082477017209,"username":"Mary Smith","price":13992.16,"status":"success"},{"order_no":"eB024DeC-DD4d-75ED-4e87-5BebAde7F8fB","timestamp":1082477017209,"username":"Edward Moore","price":12854,"status":"pending"},{"order_no":"b7C7EDCd-292E-59cb-D5ef-e6dfB2dF697e","timestamp":1082477017209,"username":"George Lewis","price":5277,"status":"pending"},{"order_no":"d9ed7BEf-9b6d-c136-AcB1-892BCb85f8A7","timestamp":1082477017209,"username":"Daniel Martinez","price":2820.4,"status":"pending"},{"order_no":"D4Aa2235-B757-fe4C-31CD-77bcbb6696F3","timestamp":1082477017209,"username":"Helen Lopez","price":12694.48,"status":"pending"},{"order_no":"1393b5D1-13FE-3546-6D9A-0E7c628bD187","timestamp":1082477017209,"username":"Brian Garcia","price":14802,"status":"pending"},{"order_no":"eAe2ACFe-6687-eB95-6Ce3-d633e2Dc023D","timestamp":1082477017209,"username":"Sharon Jones","price":8948,"status":"success"},{"order_no":"c96264e7-B37A-FA54-4b1D-d0Acf68eC749","timestamp":1082477017209,"username":"Michael Wilson","price":6533,"status":"pending"}]}}
}
