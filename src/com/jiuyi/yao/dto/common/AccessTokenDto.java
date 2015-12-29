package com.jiuyi.yao.dto.common;

/**
 * @author superb @Date 2015年12月12日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public class AccessTokenDto {

	private String accessToken;

	private Long currentTimes;

	private String cachPhone;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getCurrentTimes() {
		return currentTimes;
	}

	public void setCurrentTimes(Long currentTimes) {
		this.currentTimes = currentTimes;
	}

	public String getCachPhone() {
		return cachPhone;
	}

	public void setCachPhone(String cachPhone) {
		this.cachPhone = cachPhone;
	}

}
