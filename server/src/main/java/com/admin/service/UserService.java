package com.admin.service;

import com.admin.config.Constants;
import com.admin.entity.*;
import com.admin.mapper.CustomerMapper;
import com.admin.mapper.LoanMapper;
import com.admin.mapper.RepayMapper;
import com.admin.mapper.UserMapper;
import com.admin.util.JsonUtil;
import com.admin.util.JwtUtil;
import net.sf.json.JSONObject;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    LoanMapper loanMapper;
    @Autowired
    RepayMapper repayMapper;

    public User getUserByName(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(username);
        List<User> userList = this.userMapper.selectByExample(userExample);
        if (!userList.isEmpty())
            return userList.get(0);
        return null;
    }

    public Map<String, Object> getUserList(int page, int limit) {
        Map<String, Object> data = new HashMap<>();

        UserExample userExample = new UserExample();
        data.put("total", userMapper.countByExample(userExample));

        userExample.setOrderByClause("create_time desc");
        List<User> userList = userMapper.selectByExampleWithRowbounds(userExample, new RowBounds((page - 1) * limit, limit));

//        List<JSONObject> items = new ArrayList<>();
//        for (User user : loanList) {
//            JSONObject item = JSONObject.fromObject(loan);
//            item.put("createTime", Constants.simpleDateFormat.format(loan.getCreateTime()));
//            items.add(item);
//        }

        data.put("items", userList);
        return data;
    }

    public User update(String req) {

        Date date = new Date();
        User user = JsonUtil.toObject(req, User.class);
        user.setModifyTime(date);
        if (StringUtils.isEmpty(user.getUserId())) {
            this.userMapper.insertSelective(user);
        } else {
            this.userMapper.updateByPrimaryKeySelective(user);
            //更新其他表的用户名字
            CustomerExample customerExample = new CustomerExample();
            customerExample.createCriteria().andUserIdEqualTo(user.getUserId());
            this.customerMapper.updateByExampleSelective(new Customer() {{
                this.setUserNickname(user.getUserName());
            }}, customerExample);

            LoanExample loanExample = new LoanExample();
            loanExample.createCriteria().andUserIdEqualTo(user.getUserId());
            this.loanMapper.updateByExampleSelective(new Loan() {{
                this.setUserNickname(user.getUserName());
            }}, loanExample);

            RepayExample repayExample = new RepayExample();
            repayExample.createCriteria().andUserIdEqualTo(user.getUserId());
            this.repayMapper.updateByExampleSelective(new Repay() {{
                this.setUserNickname(user.getUserName());
            }}, repayExample);
        }

        return user;
    }
}


