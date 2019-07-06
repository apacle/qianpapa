package com.admin.service;

import com.admin.config.Constants;
import com.admin.controller.MarketingController;
import com.admin.entity.*;
import com.admin.mapper.LoanMapper;
import com.admin.mapper.MarketingMapper;
import com.admin.util.JsonUtil;
import com.admin.util.JwtUtil;
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
import java.math.BigDecimal;
import java.util.*;

@Service
public class LoanService {
    private static final Logger logger = LoggerFactory.getLogger(LoanService.class);

    @Autowired
    LoanMapper loanMapper;

    public Map<String, Object> getLoanList(int page, int limit) {
        Map<String, Object> data = new HashMap<>();

        LoanExample loanExample = new LoanExample();
        data.put("total", loanMapper.countByExample(loanExample));

        loanExample.setOrderByClause("create_time desc");
        List<Loan> loanList = loanMapper.selectByExampleWithRowbounds(loanExample, new RowBounds((page - 1) * limit, limit));

        List<JSONObject> items = new ArrayList<>();
        for (Loan loan : loanList) {
            JSONObject item = JSONObject.fromObject(loan);
            item.put("createTime", Constants.simpleDateFormat.format(loan.getCreateTime()));
            items.add(item);
        }

        data.put("items", items);
        return data;
    }

    public Loan update(String req) {
        Date date = new Date();
        Loan loan = JsonUtil.toObject(req, Loan.class);

        if (StringUtils.isEmpty(loan.getLoanId())) {
            loan.setCreateTime(date);
            this.loanMapper.insertSelective(loan);
        } else {
            this.loanMapper.updateByPrimaryKeySelective(loan);
        }

        return loan;
    }
}


