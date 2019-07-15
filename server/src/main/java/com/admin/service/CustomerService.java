package com.admin.service;

import com.admin.config.Constants;
import com.admin.entity.*;
import com.admin.enums.ResponseEnum;
import com.admin.mapper.CustomerMapper;
import com.admin.mapper.LoanMapper;
import com.admin.mapper.RepayMapper;
import com.admin.mapper.UserMapper;
import com.admin.util.HttpsIgnoeClient;
import com.admin.util.IpAdrressUtil;
import com.admin.util.JsonUtil;
import com.admin.util.ResponseUtil;
import com.google.gson.Gson;
import net.sf.json.JSONObject;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.*;

@Service
public class CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    UserMapper userMapper;
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    LoanMapper loanMapper;
    @Autowired
    RepayMapper repayMapper;
    @Autowired
    UserService userService;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

    public Response register(Map<String, String> req) {
        Customer customer = new Customer();
        try {
            Integer userId = req.containsKey("userId") ? Integer.valueOf(req.get("userId")) : 1;
            User user = this.userMapper.selectByPrimaryKey(userId);
            customer.setUserId(userId);
            customer.setUserNickname(user.getUserNickname());
            customer.setCustomerName(req.get("customerName"));
            customer.setCustomerPhone(req.get("customerPhone"));
            if (req.containsKey("customerJob"))
                customer.setCustomerJob(req.get("customerJob"));
            if (req.containsKey("customerIncome"))
                customer.setCustomerIncome(Integer.valueOf(req.get("customerIncome")));
            if (req.containsKey("customerLine"))
                customer.setCustomerLine(Integer.valueOf(req.get("customerLine")));
            if (req.containsKey("customerSex"))
                customer.setCustomerSex(Integer.valueOf(req.get("customerSex")));
            if (!StringUtils.isEmpty(req.get("marketingId")))
                customer.setMarketingId(Integer.parseInt(req.get("marketingId")));
            customer.setCustomerStatus(1);
            String customerAddress = req.get("customerAddress");
            if (StringUtils.isEmpty(customerAddress)) {

//                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
//                        .getRequest();
//                String ip = IpAdrressUtil.getIpAdrress(request);
////                logger.info("ip====>" + ip);
//                Map<String, String> parameterMap = new HashMap<>();
//                parameterMap.put("ip", ip);
//                String res = HttpsIgnoeClient.executeForm("http://ip.taobao.com/service/getIpInfo.php", parameterMap);
//                logger.info("res" + res);
//                if (null != res) {
//                    JSONObject json = JSONObject.fromObject(res);
//                    if ("0".equals(json.getString("code"))) {
//                        JSONObject data = JSONObject.fromObject(res);
//                        customer.setCustomerAddress(data.getString("country") + data.getString("region") + data.getString("city"));
//                    }
//                }
            }
            customer.setCreateTime(new Date());
            customer.setModifyTime(new Date());
            customerMapper.insertSelective(customer);
        } catch (Exception e) {
            logger.error("Customer register()", e);
            return ResponseUtil.getResponse(ResponseEnum.FAIL.getCode(), e.getCause().getMessage());
        }
        return ResponseUtil.getResponse(customer);
    }

    public JSONObject getCustomerList(int page, int limit) {
        JSONObject data = new JSONObject();

        CustomerExample customerExample = new CustomerExample();
        data.put("total", customerMapper.countByExample(customerExample));

//        List<User> userList = userService.getUserList();
//        Map<Integer, User> userMap = new HashMap<>();
//        for (User user : userList) {
//            userMap.put(user.getUserId(), user);
//        }

        customerExample.setOrderByClause("create_time desc");
        List<Customer> customerList = customerMapper.selectByExampleWithRowbounds(customerExample, new RowBounds((page - 1) * limit, limit));

        List<JSONObject> items = new ArrayList<>();
        for (Customer customer : customerList) {
            JSONObject item = JSONObject.fromObject(customer);
            item.put("createTime", Constants.simpleDateFormat.format(customer.getCreateTime()));
            items.add(item);
        }

        data.put("items", items);
        return data;
    }

    public Customer update(String req) {
        Date date = new Date();
        Customer customer = JsonUtil.toObject(req, Customer.class);

        customer.setModifyTime(date);
        if (StringUtils.isEmpty(customer.getCustomerId())) {
            customer.setCreateTime(date);
            this.customerMapper.insertSelective(customer);
        } else {
            this.customerMapper.updateByPrimaryKeySelective(customer);
            //更新其他表的客户名字
            LoanExample loanExample = new LoanExample();
            loanExample.createCriteria().andCustomerIdEqualTo(customer.getCustomerId());
            this.loanMapper.updateByExampleSelective(new Loan() {{
                this.setCustomerName(customer.getCustomerName());
            }}, loanExample);

            RepayExample repayExample = new RepayExample();
            repayExample.createCriteria().andCustomerIdEqualTo(customer.getCustomerId());
            this.repayMapper.updateByExampleSelective(new Repay() {{
                this.setCustomerName(customer.getCustomerName());
            }}, repayExample);
        }

        return customer;
    }

}


