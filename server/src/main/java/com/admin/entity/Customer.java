package com.admin.entity;

import java.util.Date;

public class Customer {
    /**
     * 
     */
    private Integer customerId;

    /**
     * 客户经理，对应users
     */
    private Integer userId;

    /**
     * 客户经理名字
     */
    private String userNickname;

    /**
     * 推广注册客户的模板Id
     */
    private Integer marketingId;

    /**
     * 
     */
    private String customerName;

    /**
     * 
     */
    private String customerPhone;

    /**
     * 
     */
    private String customerEmail;

    /**
     * 职业
     */
    private String customerJob;

    /**
     * 客户地址
     */
    private String customerAddress;

    /**
     * 贷款额度:元
     */
    private Integer customerIncome;

    /**
     * 贷款额度
     */
    private Integer customerLine;

    /**
     * 客户性别
     */
    private Integer customerSex;

    /**
     * 
     */
    private Integer customerStatus;

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
     * 客户经理，对应users
     * @return user_id 客户经理，对应users
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 客户经理，对应users
     * @param userId 客户经理，对应users
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 客户经理名字
     * @return user_nickname 客户经理名字
     */
    public String getUserNickname() {
        return userNickname;
    }

    /**
     * 客户经理名字
     * @param userNickname 客户经理名字
     */
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    /**
     * 推广注册客户的模板Id
     * @return marketing_id 推广注册客户的模板Id
     */
    public Integer getMarketingId() {
        return marketingId;
    }

    /**
     * 推广注册客户的模板Id
     * @param marketingId 推广注册客户的模板Id
     */
    public void setMarketingId(Integer marketingId) {
        this.marketingId = marketingId;
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
     * @return customer_phone 
     */
    public String getCustomerPhone() {
        return customerPhone;
    }

    /**
     * 
     * @param customerPhone 
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone == null ? null : customerPhone.trim();
    }

    /**
     * 
     * @return customer_email 
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * 
     * @param customerEmail 
     */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail == null ? null : customerEmail.trim();
    }

    /**
     * 职业
     * @return customer_job 职业
     */
    public String getCustomerJob() {
        return customerJob;
    }

    /**
     * 职业
     * @param customerJob 职业
     */
    public void setCustomerJob(String customerJob) {
        this.customerJob = customerJob == null ? null : customerJob.trim();
    }

    /**
     * 客户地址
     * @return customer_address 客户地址
     */
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     * 客户地址
     * @param customerAddress 客户地址
     */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress == null ? null : customerAddress.trim();
    }

    /**
     * 贷款额度:元
     * @return customer_income 贷款额度:元
     */
    public Integer getCustomerIncome() {
        return customerIncome;
    }

    /**
     * 贷款额度:元
     * @param customerIncome 贷款额度:元
     */
    public void setCustomerIncome(Integer customerIncome) {
        this.customerIncome = customerIncome;
    }

    /**
     * 贷款额度
     * @return customer_line 贷款额度
     */
    public Integer getCustomerLine() {
        return customerLine;
    }

    /**
     * 贷款额度
     * @param customerLine 贷款额度
     */
    public void setCustomerLine(Integer customerLine) {
        this.customerLine = customerLine;
    }

    /**
     * 客户性别
     * @return customer_sex 客户性别
     */
    public Integer getCustomerSex() {
        return customerSex;
    }

    /**
     * 客户性别
     * @param customerSex 客户性别
     */
    public void setCustomerSex(Integer customerSex) {
        this.customerSex = customerSex;
    }

    /**
     * 
     * @return customer_status 
     */
    public Integer getCustomerStatus() {
        return customerStatus;
    }

    /**
     * 
     * @param customerStatus 
     */
    public void setCustomerStatus(Integer customerStatus) {
        this.customerStatus = customerStatus;
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