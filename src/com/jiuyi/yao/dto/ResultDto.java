package com.jiuyi.yao.dto;

import java.io.Serializable;

public class ResultDto implements Serializable {
    /** serialVersionUID. */
    private static final long serialVersionUID = 2612853575778797988L;

    /** 结果码(0:成功, 1:失败). */
    private int resultCode;

    /** 结果描述. */
    private String resultDesc;

    /** 详情. */
    private Object detail;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }
}