package com.jiuyi.yao.dto.syscfg;

import com.jiuyi.yao.dto.BaseDto;

/**
 * @description 系统配置实体
 * @author zhb
 * @createTime 2015年5月6日
 */
public class SysCfgDto extends BaseDto {
	/** serialVersionUID. */
	private static final long serialVersionUID = 4071642797258475577L;

	/** id. */
	private Integer id;

	/** 名称. */
	private String configName;

	/** 值. */
	private String configValue;

	/** 类型(1:整型, 2:浮点型, 3:字符串). */
	private Integer configType;

	/** 描述. */
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public Integer getConfigType() {
		return configType;
	}

	public void setConfigType(Integer configType) {
		this.configType = configType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}