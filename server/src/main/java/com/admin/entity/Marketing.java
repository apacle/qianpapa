package com.admin.entity;

import java.util.Date;

public class Marketing {
    /**
     * 
     */
    private Integer marketingId;

    /**
     * 
     */
    private String marketingName;

    /**
     * 图片地址
     */
    private String marketingIcon;

    /**
     * 
     */
    private String marketingUrl;

    /**
     * 是否生效
     */
    private Integer marketingStatus;

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
     * @return marketing_id 
     */
    public Integer getMarketingId() {
        return marketingId;
    }

    /**
     * 
     * @param marketingId 
     */
    public void setMarketingId(Integer marketingId) {
        this.marketingId = marketingId;
    }

    /**
     * 
     * @return marketing_name 
     */
    public String getMarketingName() {
        return marketingName;
    }

    /**
     * 
     * @param marketingName 
     */
    public void setMarketingName(String marketingName) {
        this.marketingName = marketingName == null ? null : marketingName.trim();
    }

    /**
     * 图片地址
     * @return marketing_icon 图片地址
     */
    public String getMarketingIcon() {
        return marketingIcon;
    }

    /**
     * 图片地址
     * @param marketingIcon 图片地址
     */
    public void setMarketingIcon(String marketingIcon) {
        this.marketingIcon = marketingIcon == null ? null : marketingIcon.trim();
    }

    /**
     * 
     * @return marketing_url 
     */
    public String getMarketingUrl() {
        return marketingUrl;
    }

    /**
     * 
     * @param marketingUrl 
     */
    public void setMarketingUrl(String marketingUrl) {
        this.marketingUrl = marketingUrl == null ? null : marketingUrl.trim();
    }

    /**
     * 是否生效
     * @return marketing_status 是否生效
     */
    public Integer getMarketingStatus() {
        return marketingStatus;
    }

    /**
     * 是否生效
     * @param marketingStatus 是否生效
     */
    public void setMarketingStatus(Integer marketingStatus) {
        this.marketingStatus = marketingStatus;
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