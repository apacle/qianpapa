package com.admin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * User : Aliang
 * Date : 2018/04/12
 * Time : 11:24
 **/
@Component
@ConfigurationProperties(prefix = "vue")
@PropertySource("classpath:config/vue-${spring.profiles.active}.properties")
public class Properties {
    private String notifyFormUrl;
    private String notifyBodyUrl;
    private String returnUrl;
    private String redirectUrl;

    public String getNotifyFormUrl() {
        return notifyFormUrl;
    }

    public void setNotifyFormUrl(String notifyFormUrl) {
        this.notifyFormUrl = notifyFormUrl;
    }

    public String getNotifyBodyUrl() {
        return notifyBodyUrl;
    }

    public void setNotifyBodyUrl(String notifyBodyUrl) {
        this.notifyBodyUrl = notifyBodyUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
