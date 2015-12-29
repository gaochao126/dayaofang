package com.jiuyi.yao.dto;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 */
public class BaseDto implements Serializable {
    private static final long serialVersionUID = 4019098775781415190L;

    /** 鉴权使用的token. */
    private String token;

    /** 设备类型(1:WEB, 1:PC, 3:ANDROID, 4:IOS, 5:WP). */
    private Integer deviceType;

    private Page page;

    private String resultCode;

    private String resultDesc;

    /**
     * @return the page
     */
    public Page getPage() {
        return page;
    }

    /**
     * @param page
     *            the page to set
     */
    public void setPage(Page page) {
        this.page = page;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }
}