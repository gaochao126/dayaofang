package com.jiuyi.yao.dto.area;

import com.jiuyi.yao.dto.BaseDto;

/**
 * @author superb @Date 2015年12月23日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public class AreaDto extends BaseDto {

	private static final long serialVersionUID = 8190585019603730894L;

	/** 地区编号. */
	private Integer no;

	/** 地区名称. */
	private String areaname;

	/** 父级编号. */
	private Integer topno;

	/** 邮编. */
	private String areacode;

	/** 区域等级.1省，2市，3区县 */
	private Integer arealevel;

	/** 等级名称. */
	private String typename;

	private Integer id;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public Integer getTopno() {
		return topno;
	}

	public void setTopno(Integer topno) {
		this.topno = topno;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public Integer getArealevel() {
		return arealevel;
	}

	public void setArealevel(Integer arealevel) {
		this.arealevel = arealevel;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
