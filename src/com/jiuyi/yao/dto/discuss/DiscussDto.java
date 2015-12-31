package com.jiuyi.yao.dto.discuss;

import com.jiuyi.yao.dto.BaseDto;

/**
 * @author superb    @Date 2015年12月30日
 * 
 * @Description 
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public class DiscussDto extends BaseDto {

	private static final long serialVersionUID = -8787968110141950475L;
	private String dis_id;
	private String user_id;
	private String dis_name;
	private String prod_id;
	private String dis_mess;
	private Integer prod_score;
	private Integer service_score;
	private Integer speed_score;
	private Integer trans_score;
	private String user_ip;
	private String dis_time;
	private Integer dis_status;
	private Integer anmou_status;
	private String order_id;

	public String getDis_id() {
		return dis_id;
	}

	public void setDis_id(String dis_id) {
		this.dis_id = dis_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getDis_name() {
		return dis_name;
	}

	public void setDis_name(String dis_name) {
		this.dis_name = dis_name;
	}

	public String getProd_id() {
		return prod_id;
	}

	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}

	public String getDis_mess() {
		return dis_mess;
	}

	public void setDis_mess(String dis_mess) {
		this.dis_mess = dis_mess;
	}

	public Integer getProd_score() {
		return prod_score;
	}

	public void setProd_score(Integer prod_score) {
		this.prod_score = prod_score;
	}

	public Integer getService_score() {
		return service_score;
	}

	public void setService_score(Integer service_score) {
		this.service_score = service_score;
	}

	public Integer getSpeed_score() {
		return speed_score;
	}

	public void setSpeed_score(Integer speed_score) {
		this.speed_score = speed_score;
	}

	public Integer getTrans_score() {
		return trans_score;
	}

	public void setTrans_score(Integer trans_score) {
		this.trans_score = trans_score;
	}

	public String getUser_ip() {
		return user_ip;
	}

	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}

	public String getDis_time() {
		return dis_time;
	}

	public void setDis_time(String dis_time) {
		this.dis_time = dis_time;
	}

	public Integer getDis_status() {
		return dis_status;
	}

	public void setDis_status(Integer dis_status) {
		this.dis_status = dis_status;
	}

	public Integer getAnmou_status() {
		return anmou_status;
	}

	public void setAnmou_status(Integer anmou_status) {
		this.anmou_status = anmou_status;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

}
