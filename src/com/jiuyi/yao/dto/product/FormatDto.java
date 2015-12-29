package com.jiuyi.yao.dto.product;

import java.math.BigDecimal;

import com.jiuyi.yao.dto.BaseDto;

/**
 * @author superb @Date 2015年12月11日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public class FormatDto extends BaseDto {

	private static final long serialVersionUID = -2176316653759618572L;
	private String format_id;
	private String prod_id;
	private String prod_format;
	private String prod_unit;
	private String prod_pack;
	private BigDecimal prod_price;
	private int prod_sku;
	private int format_status;

	public String getFormat_id() {
		return format_id;
	}

	public void setFormat_id(String format_id) {
		this.format_id = format_id;
	}

	public String getProd_id() {
		return prod_id;
	}

	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
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

	public BigDecimal getProd_price() {
		return prod_price;
	}

	public void setProd_price(BigDecimal prod_price) {
		this.prod_price = prod_price;
	}

	public int getProd_sku() {
		return prod_sku;
	}

	public void setProd_sku(int prod_sku) {
		this.prod_sku = prod_sku;
	}

	public int getFormat_status() {
		return format_status;
	}

	public void setFormat_status(int format_status) {
		this.format_status = format_status;
	}

	public String getProd_unit() {
		return prod_unit;
	}

	public void setProd_unit(String prod_unit) {
		this.prod_unit = prod_unit;
	}
}
