package com.jiuyi.yao.dto.refund;

import java.util.Date;

import com.jiuyi.yao.dto.BaseDto;

/**
 * @author superb @Date 2015年12月15日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public class RefundDto extends BaseDto {
	private static final long serialVersionUID = 1607851356562721366L;

	/** 退款单号. */
	private String id;

	/** 订单号. */
	private String outTradeNo;

	/**
	 * 退款状态. 0.申请中 1.退款成功 2.退款失败',
	 * 
	 * */
	private Integer status;

	/** 申请时间. */
	private Date startTime;

	/** 结束时间. */
	private Date endTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
