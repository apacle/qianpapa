package com.admin.entity;

import java.util.Date;

public class User {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 
     */
    private String userPassword;

    /**
     * 
     */
    private String userName;

    /**
     * 昵称
     */
    private String userNickname;

    /**
     * 
     */
    private String userPhone;

    /**
     * 
     */
    private String userEmail;

    /**
     * 性别
     */
    private Integer userSex;

    /**
     * 用户等级：0普通，1编辑者，2管理者
     */
    private String userRole;

    /**
     * 
     */
    private String userUrl;

    /**
     * 
     */
    private String userAvater;

    /**
     * 用户介绍
     */
    private String userIntro;

    /**
     * 
     */
    private Integer userStatus;

    /**
     * 
     */
    private String userAddress;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date modifyTime;

    /**
     * 用户ID
     * @return user_id 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户ID
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 
     * @return user_password 
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 
     * @param userPassword 
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * 
     * @return user_name 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 昵称
     * @return user_nickname 昵称
     */
    public String getUserNickname() {
        return userNickname;
    }

    /**
     * 昵称
     * @param userNickname 昵称
     */
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    /**
     * 
     * @return user_phone 
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 
     * @param userPhone 
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * 
     * @return user_email 
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * 
     * @param userEmail 
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    /**
     * 性别
     * @return user_sex 性别
     */
    public Integer getUserSex() {
        return userSex;
    }

    /**
     * 性别
     * @param userSex 性别
     */
    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    /**
     * 用户等级：0普通，1编辑者，2管理者
     * @return user_role 用户等级：0普通，1编辑者，2管理者
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * 用户等级：0普通，1编辑者，2管理者
     * @param userRole 用户等级：0普通，1编辑者，2管理者
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }

    /**
     * 
     * @return user_url 
     */
    public String getUserUrl() {
        return userUrl;
    }

    /**
     * 
     * @param userUrl 
     */
    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl == null ? null : userUrl.trim();
    }

    /**
     * 
     * @return user_avater 
     */
    public String getUserAvater() {
        return userAvater;
    }

    /**
     * 
     * @param userAvater 
     */
    public void setUserAvater(String userAvater) {
        this.userAvater = userAvater == null ? null : userAvater.trim();
    }

    /**
     * 用户介绍
     * @return user_intro 用户介绍
     */
    public String getUserIntro() {
        return userIntro;
    }

    /**
     * 用户介绍
     * @param userIntro 用户介绍
     */
    public void setUserIntro(String userIntro) {
        this.userIntro = userIntro == null ? null : userIntro.trim();
    }

    /**
     * 
     * @return user_status 
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * 
     * @param userStatus 
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * 
     * @return user_address 
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * 
     * @param userAddress 
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
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