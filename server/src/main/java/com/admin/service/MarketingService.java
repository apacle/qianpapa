package com.admin.service;

import com.admin.controller.MarketingController;
import com.admin.entity.Marketing;
import com.admin.entity.MarketingExample;
import com.admin.mapper.MarketingMapper;
import com.admin.util.JwtUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MarketingService {
    private static final Logger logger = LoggerFactory.getLogger(MarketingService.class);

    @Autowired
    MarketingMapper marketingMapper;

    public Map<String, Object> getMarketingList(int page, int limit) {
        Map<String, Object> data = new HashMap<>();

        MarketingExample marketingExample = new MarketingExample();
        data.put("total", marketingMapper.countByExample(marketingExample));

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String token = request.getHeader("X-Token");
        Integer userId = JwtUtil.getUserId(token);

        marketingExample.setOrderByClause("create_time desc");
        List<Marketing> marketingList = marketingMapper.selectByExampleWithRowbounds(marketingExample, new RowBounds((page - 1) * limit, limit));

        for (Marketing marketing : marketingList) {
            String url = marketing.getMarketingUrl();
            if (url.indexOf("?") != -1)
                marketing.setMarketingUrl(url + "&userId=" + userId);
            else
                marketing.setMarketingUrl(url + "?userId=" + userId);
        }
        logger.info("marketingList" + JSONArray.fromObject(marketingList).toString());
        data.put("items", marketingList);
        return data;
    }

    public Marketing update(String req) {
        JSONObject json = JSONObject.fromObject(req);
        Date date = new Date();
        Marketing marketing = new Marketing();
        marketing.setMarketingName(json.getString("marketingName"));
        marketing.setMarketingIcon(json.getString("marketingIcon"));
        marketing.setMarketingUrl(json.getString("marketingUrl"));
        marketing.setMarketingStatus(json.getInt("marketingStatus"));
        marketing.setModifyTime(date);
        if (json.has("marketingId")) {
            marketing.setMarketingId(json.getInt("marketingId"));
            this.marketingMapper.updateByPrimaryKeySelective(marketing);
        } else {
            marketing.setCreateTime(date);
            this.marketingMapper.insertSelective(marketing);
        }

        return marketing;
    }
}


