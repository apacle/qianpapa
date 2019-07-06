package com.admin.service;

import com.admin.config.Constants;
import com.admin.entity.Loan;
import com.admin.entity.Repay;
import com.admin.entity.RepayExample;
import com.admin.mapper.RepayMapper;
import com.admin.util.JsonUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class RepayService {
    private static final Logger logger = LoggerFactory.getLogger(RepayService.class);

    @Autowired
    RepayMapper repayMapper;

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

    public Repay update(String req) {
        Date date = new Date();
        Repay repay = JsonUtil.toObject(req, Repay.class);
        repay.setModifyTime(date);
        if (StringUtils.isEmpty(repay.getRepayId())) {
            repay.setCreateTime(date);
            this.repayMapper.insertSelective(repay);
        } else {
            this.repayMapper.updateByPrimaryKeySelective(repay);
        }

        return repay;
    }
}


