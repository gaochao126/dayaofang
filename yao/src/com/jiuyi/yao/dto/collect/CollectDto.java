package com.jiuyi.yao.dto.collect;

import java.math.BigDecimal;

import com.jiuyi.yao.dto.BaseDto;

/**
 * @author superb    @Date 2016年1月7日
 * 
 * @Description 
 *
 * @Copyright 2016 重庆柒玖壹健康管理有限公司
 */
public class CollectDto extends BaseDto {

	private static final long serialVersionUID = 945249801684273009L;

	private String coll_id;

	private String prod_id;

	private String user_id;

	private String format_id;

	private String prod_name;

	private String prod_commonName;

	private String prod_certno;

	private Integer prod_discount;

	private String prod_chandi;

	private String prod_function;

	private String img_id;

	private String prod_pack;

	private BigDecimal prod_price;

	private String prod_format;

	private Integer img_type;

	private String img_src;

	public String getColl_id() {
		return coll_id;
	}

	public void setColl_id(String coll_id) {
		this.coll_id = coll_id;
	}

	public String getProd_id() {
		return prod_id;
	}

	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getFormat_id() {
		return format_id;
	}

	public void setFormat_id(String format_id) {
		this.format_id = format_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public String getProd_commonName() {
		return prod_commonName;
	}

	public void setProd_commonName(String prod_commonName) {
		this.prod_commonName = prod_commonName;
	}

	public String getProd_certno() {
		return prod_certno;
	}

	public void setProd_certno(String prod_certno) {
		this.prod_certno = prod_certno;
	}

	public Integer getProd_discount() {
		return prod_discount;
	}

	public void setProd_discount(Integer prod_discount) {
		this.prod_discount = prod_discount;
	}

	public String getProd_chandi() {
		return prod_chandi;
	}

	public void setProd_chandi(String prod_chandi) {
		this.prod_chandi = prod_chandi;
	}

	public String getProd_function() {
		return prod_function;
	}

	public void setProd_function(String prod_function) {
		this.prod_function = prod_function;
	}

	public String getImg_id() {
		return img_id;
	}

	public void setImg_id(String img_id) {
		this.img_id = img_id;
	}

	public String getProd_pack() {
		return prod_pack;
	}

	public void setProd_pack(String prod_pack) {
		this.prod_pack = prod_pack;
	}

	public BigDecimal getProd_price() {
		return prod_price;
	}

	public void setProd_price(BigDecimal prod_price) {
		this.prod_price = prod_price;
	}

	public String getProd_format() {
		return prod_format;
	}

	public void setProd_format(String prod_format) {
		this.prod_format = prod_format;
	}

	public Integer getImg_type() {
		return img_type;
	}

	public void setImg_type(Integer img_type) {
		this.img_type = img_type;
	}

	public String getImg_src() {
		return img_src;
	}

	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}

}
