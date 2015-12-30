package com.jiuyi.yao.dto.area;

import com.jiuyi.yao.dto.BaseDto;

/**
 * @author superb    @Date 2015年12月30日
 * 
 * @Description 
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public class AddressDto extends BaseDto {

	private static final long serialVersionUID = -3819932344607160188L;

	private String addr_id;
	private String user_id;
	private String person_name;
	private String addr_provence;
	private String addr_city;
	private String addr_country;
	private String addr_stree;
	private String addr_mail;
	private String phone;
	private Integer addr_status;
	private Integer delete_status;

	public String getAddr_id() {
		return addr_id;
	}

	public void setAddr_id(String addr_id) {
		this.addr_id = addr_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

	public String getAddr_provence() {
		return addr_provence;
	}

	public void setAddr_provence(String addr_provence) {
		this.addr_provence = addr_provence;
	}

	public String getAddr_city() {
		return addr_city;
	}

	public void setAddr_city(String addr_city) {
		this.addr_city = addr_city;
	}

	public String getAddr_country() {
		return addr_country;
	}

	public void setAddr_country(String addr_country) {
		this.addr_country = addr_country;
	}

	public String getAddr_stree() {
		return addr_stree;
	}

	public void setAddr_stree(String addr_stree) {
		this.addr_stree = addr_stree;
	}

	public String getAddr_mail() {
		return addr_mail;
	}

	public void setAddr_mail(String addr_mail) {
		this.addr_mail = addr_mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getAddr_status() {
		return addr_status;
	}

	public void setAddr_status(Integer addr_status) {
		this.addr_status = addr_status;
	}

	public Integer getDelete_status() {
		return delete_status;
	}

	public void setDelete_status(Integer delete_status) {
		this.delete_status = delete_status;
	}

}
