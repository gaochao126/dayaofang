package com.jiuyi.yao.dto.common;

import java.io.Serializable;

import com.jiuyi.yao.dto.customer.CustomerDto;

/**
 * @description toke实体类
 * @author zhb
 * @createTime 2015年4月7日
 */
public class TokenDto implements Serializable {
	/** serialVersionUID. */
	private static final long serialVersionUID = 2297851842800437936L;

	private String token;

	private CustomerDto customerDto;

	private long updateTime;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public CustomerDto getCustomerDto() {
		return customerDto;
	}

	public void setCustomerDto(CustomerDto customerDto) {
		this.customerDto = customerDto;
	}

	public long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}
}