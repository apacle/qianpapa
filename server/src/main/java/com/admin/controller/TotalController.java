package com.admin.controller;


import com.admin.entity.*;
import com.admin.enums.ResponseEnum;
import com.admin.mapper.CustomerMapper;
import com.admin.mapper.LoanMapper;
import com.admin.mapper.RepayMapper;
import com.admin.mapper.UserMapper;
import com.admin.service.UserService;
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

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Api(tags = "TotalController", description = "总情况接口")
@RestController
@RequestMapping(value = "/total", produces = "application/json; charset=utf-8")
public class TotalController {
    private static final Logger logger = LoggerFactory.getLogger(TotalController.class);
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    LoanMapper loanMapper;
    @Autowired
    RepayMapper repayMapper;

    @ApiModelProperty(value = "总数量", notes = "总数量")
    @ApiResponse(code = 200, message = "总数量")
    @RequestMapping("/amount")
    public Response amount() {

        JSONObject data = new JSONObject();
        data.put("customer", customerMapper.countByExample(new CustomerExample()));
        data.put("user", userMapper.countByExample(new UserExample()));

        LoanExample loanExample = new LoanExample();
        loanExample.createCriteria().andLoanStatusNotEqualTo(0);
        List<Loan> loanList = loanMapper.selectByExample(loanExample);
        BigDecimal totalLoan = BigDecimal.ZERO;
        for (Loan loan : loanList) {
            totalLoan = totalLoan.add(loan.getLoanAmount());
        }
        RepayExample repayExample = new RepayExample();
        repayExample.createCriteria().andRepayStatusNotEqualTo(0);
        List<Repay> repayList = repayMapper.selectByExample(repayExample);
        BigDecimal totalRepay = BigDecimal.ZERO;
        for (Repay repay : repayList) {
            totalRepay = totalRepay.add(repay.getRepayAmount());
        }
        data.put("loan", totalLoan);
        data.put("repay", totalRepay);
        return ResponseUtil.getResponse(data);
    }

    @ApiModelProperty(value = "列表", notes = "列表")
    @ApiResponse(code = 200, message = "列表")
    @RequestMapping("/list")
    public Response list() {
        //7天前
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.add(Calendar.DAY_OF_MONTH, -7);

        List<Date> dateList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            dateList.add(calendar.getTime());
        }
        Date firstDate = dateList.get(0);

        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCreateTimeGreaterThan(firstDate);
        List<Customer> customerList = customerMapper.selectByExample(customerExample);

        LoanExample loanExample = new LoanExample();
        loanExample.createCriteria().andCreateTimeGreaterThan(firstDate);
        List<Loan> loanList = loanMapper.selectByExample(loanExample);

        RepayExample repayExample = new RepayExample();
        repayExample.createCriteria().andCreateTimeGreaterThan(firstDate);
        List<Repay> repayList = repayMapper.selectByExample(repayExample);

        int customerArr[] = {0, 0, 0, 0, 0, 0, 0};
        BigDecimal loanArr[] = {BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO};
        BigDecimal repayArr[] = {BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO};

        for (int j = 6; j > -1; j--) {
            Date date = dateList.get(j);
            for (int k1 = customerList.size() - 1; k1 > -1; k1--) {
                Customer customer = customerList.get(k1);
                if (customer.getCreateTime().after(date)) {
                    customerArr[j] += 1;
                    customerList.remove(k1);
                }
            }

            for (int k2 = loanList.size() - 1; k2 > -1; k2--) {
                Loan loan = loanList.get(k2);
                if (loan.getCreateTime().after(date)) {
                    loanArr[j] = loanArr[j].add(loan.getLoanAmount());
                    loanList.remove(k2);
                }
            }

            for (int k3 = repayList.size() - 1; k3 > -1; k3--) {
                Repay repay = repayList.get(k3);
                if (repay.getCreateTime().after(date)) {
                    repayArr[j] = repayArr[j].add(repay.getRepayAmount());
                    repayList.remove(k3);
                }
            }
        }
        for (int l = 0; l < loanArr.length; l++) {
            loanArr[l] = loanArr[l].divide(new BigDecimal(10000), 2, BigDecimal.ROUND_DOWN);
            repayArr[l] = repayArr[l].divide(new BigDecimal(10000), 2, BigDecimal.ROUND_DOWN);
        }

        JSONObject data = new JSONObject();
        data.put("customer", customerArr);
        data.put("loan", loanArr);
        data.put("repay", repayArr);
        return ResponseUtil.getResponse(data);
    }

//transaction/list
//    {"code":20000,"data":{"total":20,"items":[{"order_no":"F1CC1faF-A851-ACf3-B8eC-d73bF93Cb13a","timestamp":1082477017209,"username":"Jose Young","price":13052.4,"status":"pending"},{"order_no":"5AA5FcDe-5285-4CBb-A12f-d8107f3EE612","timestamp":1082477017209,"username":"Eric Davis","price":12183.1,"status":"pending"},{"order_no":"2Ac58BBB-2568-d8Cb-b6d2-F840A8c6fcDf","timestamp":1082477017209,"username":"Kimberly Johnson","price":6020.3,"status":"pending"},{"order_no":"57713E4B-fFa0-7dBE-f98A-1FAC3DBc28E8","timestamp":1082477017209,"username":"Patricia Walker","price":2352.72,"status":"success"},{"order_no":"9DfDAF27-052c-7FAC-6EDe-DDf3bA79184e","timestamp":1082477017209,"username":"Ruth Brown","price":14727.1,"status":"pending"},{"order_no":"74Abe7CC-98c6-1593-D2c9-3Ca5Dc77efbc","timestamp":1082477017209,"username":"Deborah Taylor","price":2533.7,"status":"pending"},{"order_no":"1D5B46c7-50Bd-1F1B-9890-c1ACd4CdDeBf","timestamp":1082477017209,"username":"Barbara Smith","price":6243.04,"status":"pending"},{"order_no":"C37Ea2d7-84FA-b9Db-6DDE-f2B2B724fEEB","timestamp":1082477017209,"username":"Jason Lopez","price":7119.5,"status":"success"},{"order_no":"E18De72B-53Ec-E1F2-d9b6-b50fBBd7d3E2","timestamp":1082477017209,"username":"Kevin Lee","price":4884.42,"status":"success"},{"order_no":"4196A3aD-1fF9-4c6E-c99F-B62DB27c99E5","timestamp":1082477017209,"username":"Kevin Davis","price":13121,"status":"success"},{"order_no":"8c4ddA6D-6DCe-3FF4-dbb0-3BAB9DeeCe1c","timestamp":1082477017209,"username":"Richard Johnson","price":4495.7,"status":"success"},{"order_no":"077fbF3E-DE8f-d65F-86dA-93CcCdfe4eEb","timestamp":1082477017209,"username":"Susan Jones","price":6122,"status":"pending"},{"order_no":"D7DfF49E-12AC-6219-e3Aa-9ECd9BE3E4D8","timestamp":1082477017209,"username":"Mary Smith","price":13992.16,"status":"success"},{"order_no":"eB024DeC-DD4d-75ED-4e87-5BebAde7F8fB","timestamp":1082477017209,"username":"Edward Moore","price":12854,"status":"pending"},{"order_no":"b7C7EDCd-292E-59cb-D5ef-e6dfB2dF697e","timestamp":1082477017209,"username":"George Lewis","price":5277,"status":"pending"},{"order_no":"d9ed7BEf-9b6d-c136-AcB1-892BCb85f8A7","timestamp":1082477017209,"username":"Daniel Martinez","price":2820.4,"status":"pending"},{"order_no":"D4Aa2235-B757-fe4C-31CD-77bcbb6696F3","timestamp":1082477017209,"username":"Helen Lopez","price":12694.48,"status":"pending"},{"order_no":"1393b5D1-13FE-3546-6D9A-0E7c628bD187","timestamp":1082477017209,"username":"Brian Garcia","price":14802,"status":"pending"},{"order_no":"eAe2ACFe-6687-eB95-6Ce3-d633e2Dc023D","timestamp":1082477017209,"username":"Sharon Jones","price":8948,"status":"success"},{"order_no":"c96264e7-B37A-FA54-4b1D-d0Acf68eC749","timestamp":1082477017209,"username":"Michael Wilson","price":6533,"status":"pending"}]}}
}
