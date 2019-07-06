package com.admin.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Repay {
    /**
     * 
     */
    private Integer repayId;

    /**
     * 贷款单号
     */
    private Integer loanId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private String userNickname;

    /**
     * 
     */
    private Integer customerId;

    /**
     * 
     */
    private String customerName;

    /**
     * 
     */
    private BigDecimal repayAmount;

    /**
     * 还款状态:0未审核 1通过
     */
    private Integer repayStatus;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date modifyTime;

    /**
     * 
     * @return repay_id 
     */
    public Integer getRepayId() {
        return repayId;
    }

    /**
     * 
     * @param repayId 
     */
    public void setRepayId(Integer repayId) {
        this.repayId = repayId;
    }

    /**
     * 贷款单号
     * @return loan_id 贷款单号
     */
    public Integer getLoanId() {
        return loanId;
    }

    /**
     * 贷款单号
     * @param loanId 贷款单号
     */
    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
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
     * 
     * @return user_nickname 
     */
    public String getUserNickname() {
        return userNickname;
    }

    /**
     * 
     * @param userNickname 
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
     * 
     * @return customer_name 
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 
     * @param customerName 
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    /**
     * 
     * @return repay_amount 
     */
    public BigDecimal getRepayAmount() {
        return repayAmount;
    }

    /**
     * 
     * @param repayAmount 
     */
    public void setRepayAmount(BigDecimal repayAmount) {
        this.repayAmount = repayAmount;
    }

    /**
     * 还款状态:0未审核 1通过
     * @return repay_status 还款状态:0未审核 1通过
     */
    public Integer getRepayStatus() {
        return repayStatus;
    }

    /**
     * 还款状态:0未审核 1通过
     * @param repayStatus 还款状态:0未审核 1通过
     */
    public void setRepayStatus(Integer repayStatus) {
        this.repayStatus = repayStatus;
    }

    /**
     * 
     * @return create_time 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * @return modify_time 
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * @param modifyTime 
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}