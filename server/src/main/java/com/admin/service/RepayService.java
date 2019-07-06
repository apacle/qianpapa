package com.admin.service;

import com.admin.config.Constants;
import com.admin.entity.*;
import com.admin.enums.ResponseEnum;
import com.admin.mapper.CustomerMapper;
import com.admin.mapper.LoanMapper;
import com.admin.mapper.RepayMapper;
import com.admin.mapper.UserMapper;
import com.admin.util.JsonUtil;
import com.admin.util.JwtUtil;
import com.admin.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class RepayService {
    private static final Logger logger = LoggerFactory.getLogger(RepayService.class);

    @Autowired
    RepayMapper repayMapper;
    @Autowired
    LoanMapper loanMapper;
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    UserMapper userMapper;

    public Map<String, Object> getRepayList(int page, int limit) {
        Map<String, Object> data = new HashMap<>();

        RepayExample repayExample = new RepayExample();
        data.put("total", repayMapper.countByExample(repayExample));

        repayExample.setOrderByClause("create_time desc");
        List<Repay> RepayList = repayMapper.selectByExampleWithRowbounds(repayExample, new RowBounds((page - 1) * limit, limit));

        List<JSONObject> items = new ArrayList<>();
        for (Repay repay : RepayList) {
            JSONObject item = JSONObject.fromObject(repay);
            item.put("createTime", Constants.simpleDateFormat.format(repay.getCreateTime()));
            items.add(item);
        }

        data.put("items", items);
        return data;
    }

    public Response update(String req) {
        Date date = new Date();
        Repay repay = JsonUtil.toObject(req, Repay.class);
        repay.setModifyTime(date);

        if (StringUtils.isEmpty(repay.getRepayId())) {
            Loan loan = loanMapper.selectByPrimaryKey(repay.getLoanId());
            if (null == loan) {
                return ResponseUtil.getResponse(ResponseEnum.FAIL.getCode(), "贷款编号不正确");
            }

            Customer customer = this.customerMapper.selectByPrimaryKey(loan.getCustomerId());
            if (null == customer)
                return ResponseUtil.getResponse(ResponseEnum.FAIL.getCode(), "贷款人不存在");
            repay.setCustomerName(customer.getCustomerName());
            //核查经理人
            if (StringUtils.isEmpty(repay.getUserId())) {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                        .getRequest();
                String token = request.getHeader("X-Token");
                Integer userId = JwtUtil.getUserId(token);
                repay.setUserId(userId);
            }

            User user = this.userMapper.selectByPrimaryKey(repay.getUserId());
            if (null == user)
                return ResponseUtil.getResponse(ResponseEnum.FAIL.getCode(), "经理人不存在");
            repay.setUserNickname(user.getUserNickname());

            repay.setCreateTime(date);
            this.repayMapper.insertSelective(repay);
        } else {
            this.repayMapper.updateByPrimaryKeySelective(repay);
        }
        return ResponseUtil.getResponse(repay);
    }
}


