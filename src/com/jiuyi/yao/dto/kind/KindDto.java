package com.jiuyi.yao.dto.kind;

import com.jiuyi.yao.dto.BaseDto;

/**
 * @author superb @Date 2015年12月17日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public class KindDto extends BaseDto {

	private static final long serialVersionUID = -7862434768955812213L;
	private String type_id;
	private String second_id;
	private String third_id;
	private String type_name;
	private String second_name;
	private String third_name;

	public String getType_id() {
		return type_id;
	}

	public void setType_id(String type_id) {
		this.type_id = type_id;
	}

	public String getSecond_id() {
		return second_id;
	}

	public void setSecond_id(String second_id) {
		this.second_id = second_id;
	}

	public String getThird_id() {
		return third_id;
	}

	public void setThird_id(String third_id) {
		this.third_id = third_id;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getSecond_name() {
		return second_name;
	}

	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}

	public String getThird_name() {
		return third_name;
	}

	public void setThird_name(String third_name) {
		this.third_name = third_name;
	}

}
