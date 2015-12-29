package com.jiuyi.yao.dto.shopcar;

import java.math.BigDecimal;

import com.jiuyi.yao.dto.BaseDto;

/**
 * @author superb @Date 2015年12月25日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public class ShopCarDto extends BaseDto {

	private static final long serialVersionUID = -3912619810136861080L;

	private String car_id;

	private String user_id;

	private String ieme;

	private String prod_id;

	private Integer buy_count;

	private Integer car_status;

	private String format_id;

	private String prod_name;
	private String prod_certno;
	private String prod_discount;
	private String prod_function;
	private String img_id;
	private String prod_taboo;
	private Integer prod_xl;
	private String prod_format;
	private String prod_pack;
	private String prod_unit;
	private BigDecimal prod_price;
	private Integer prod_sku;
	private String img_src;
	private Integer img_type;
	// 单条商品小计
	private BigDecimal singleAmount;
	// 所有商品总价
	private BigDecimal totalAmount;

	public String getCar_id() {
		return car_id;
	}

	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getIeme() {
		return ieme;
	}

	public void setIeme(String ieme) {
		this.ieme = ieme;
	}

	public String getProd_id() {
		return prod_id;
	}

	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}

	public Integer getBuy_count() {
		return buy_count;
	}

	public void setBuy_count(Integer buy_count) {
		this.buy_count = buy_count;
	}

	public Integer getCar_status() {
		return car_status;
	}

	public void setCar_status(Integer car_status) {
		this.car_status = car_status;
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

	public String getProd_certno() {
		return prod_certno;
	}

	public void setProd_certno(String prod_certno) {
		this.prod_certno = prod_certno;
	}

	public String getProd_discount() {
		return prod_discount;
	}

	public void setProd_discount(String prod_discount) {
		this.prod_discount = prod_discount;
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

	public String getProd_taboo() {
		return prod_taboo;
	}

	public void setProd_taboo(String prod_taboo) {
		this.prod_taboo = prod_taboo;
	}

	public Integer getProd_xl() {
		return prod_xl;
	}

	public void setProd_xl(Integer prod_xl) {
		this.prod_xl = prod_xl;
	}

	public String getProd_format() {
		return prod_format;
	}

	public void setProd_format(String prod_format) {
		this.prod_format = prod_format;
	}

	public String getProd_pack() {
		return prod_pack;
	}

	public void setProd_pack(String prod_pack) {
		this.prod_pack = prod_pack;
	}

	public String getProd_unit() {
		return prod_unit;
	}

	public void setProd_unit(String prod_unit) {
		this.prod_unit = prod_unit;
	}

	public BigDecimal getProd_price() {
		return prod_price;
	}

	public void setProd_price(BigDecimal prod_price) {
		this.prod_price = prod_price;
	}

	public Integer getProd_sku() {
		return prod_sku;
	}

	public void setProd_sku(Integer prod_sku) {
		this.prod_sku = prod_sku;
	}

	public String getImg_src() {
		return img_src;
	}

	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}

	public Integer getImg_type() {
		return img_type;
	}

	public void setImg_type(Integer img_type) {
		this.img_type = img_type;
	}

	public BigDecimal getSingleAmount() {
		return singleAmount;
	}

	public void setSingleAmount(BigDecimal singleAmount) {
		this.singleAmount = singleAmount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

}
