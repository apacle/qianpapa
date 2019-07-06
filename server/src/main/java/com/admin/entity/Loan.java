package com.admin.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Loan {
    /**
     * 贷款
     */
    private Integer loanId;

    /**
     * 
     */
    private String loanName;

    /**
     * 
     */
    private Integer userId;

    /**
     * 负责经理
     */
    private String userNickname;

    /**
     * 
     */
    private Integer customerId;

    /**
     * 贷款人
     */
    private String customerName;

    /**
     * 还款方式
     */
    private Integer loanType;

    /**
     * 手续费
     */
    private BigDecimal loanFee;

    /**
     * 利息,万几一天
     */
    private BigDecimal loadInterest;

    /**
     * 本金
     */
    private BigDecimal loanAmount;

    /**
     * 当前总金额，每天更新计算
     */
    private BigDecimal loanTotalAmount;

    /**
     * 已还金额
     */
    private BigDecimal loanRepayAmount;

    /**
     * 0未审核,1贷款中,2还完款,3逾期
     */
    private Integer loanStatus;

    /**
     * 截止日期
     */
    private Date loanEndDate;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date modifyTime;

    /**
     * 贷款
     * @return loan_id 贷款
     */
    public Integer getLoanId() {
        return loanId;
    }

    /**
     * 贷款
     * @param loanId 贷款
     */
    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    /**
     * 
     * @return loan_name 
     */
    public String getLoanName() {
        return loanName;
    }

    /**
     * 
     * @param loanName 
     */
    public void setLoanName(String loanName) {
        this.loanName = loanName == null ? null : loanName.trim();
    }

    /**
     * 
     * @return user_id 
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId 
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 负责经理
     * @return user_nickname 负责经理
     */
    public String getUserNickname() {
        return userNickname;
    }

    /**
     * 负责经理
     * @param userNickname 负责经理
     */
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    /**
     * 
     * @return customer_id 
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * 
     * @param customerId 
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * 贷款人
     * @return customer_name 贷款人
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 贷款人
     * @param customerName 贷款人
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    /**
     * 还款方式
     * @return loan_type 还款方式
     */
    public Integer getLoanType() {
        return loanType;
    }

    /**
     * 还款方式
     * @param loanType 还款方式
     */
    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
    }

    /**
     * 手续费
     * @return loan_fee 手续费
     */
    public BigDecimal getLoanFee() {
        return loanFee;
    }

    /**
     * 手续费
     * @param loanFee 手续费
     */
    public void setLoanFee(BigDecimal loanFee) {
        this.loanFee = loanFee;
    }

    /**
     * 利息,万几一天
     * @return load_interest 利息,万几一天
     */
    public BigDecimal getLoadInterest() {
        return loadInterest;
    }

    /**
     * 利息,万几一天
     * @param loadInterest 利息,万几一天
     */
    public void setLoadInterest(BigDecimal loadInterest) {
        this.loadInterest = loadInterest;
    }

    /**
     * 本金
     * @return loan_amount 本金
     */
    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    /**
     * 本金
     * @param loanAmount 本金
     */
    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * 当前总金额，每天更新计算
     * @return loan_total_amount 当前总金额，每天更新计算
     */
    public BigDecimal getLoanTotalAmount() {
        return loanTotalAmount;
    }

    /**
     * 当前总金额，每天更新计算
     * @param loanTotalAmount 当前总金额，每天更新计算
     */
    public void setLoanTotalAmount(BigDecimal loanTotalAmount) {
        this.loanTotalAmount = loanTotalAmount;
    }

    /**
     * 已还金额
     * @return loan_repay_amount 已还金额
     */
    public BigDecimal getLoanRepayAmount() {
        return loanRepayAmount;
    }

    /**
     * 已还金额
     * @param loanRepayAmount 已还金额
     */
    public void setLoanRepayAmount(BigDecimal loanRepayAmount) {
        this.loanRepayAmount = loanRepayAmount;
    }

    /**
     * 0未审核,1贷款中,2还完款,3逾期
     * @return loan_status 0未审核,1贷款中,2还完款,3逾期
     */
    public Integer getLoanStatus() {
        return loanStatus;
    }

    /**
     * 0未审核,1贷款中,2还完款,3逾期
     * @param loanStatus 0未审核,1贷款中,2还完款,3逾期
     */
    public void setLoanStatus(Integer loanStatus) {
        this.loanStatus = loanStatus;
    }

    /**
     * 截止日期
     * @return loan_end_date 截止日期
     */
    public Date getLoanEndDate() {
        return loanEndDate;
    }

    /**
     * 截止日期
     * @param loanEndDate 截止日期
     */
    public void setLoanEndDate(Date loanEndDate) {
        this.loanEndDate = loanEndDate;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     * @return modify_time 更新时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 更新时间
     * @param modifyTime 更新时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}