package com.jiuyi.yao.dto.product;

import java.math.BigDecimal;
import java.util.List;

import com.jiuyi.yao.dto.BaseDto;

/**
 * @author superb @Date 2015年12月11日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public class ProductDto extends BaseDto {

	private static final long serialVersionUID = 3825527478409646399L;

	private String prod_id;
	private String prod_name;

	/** 一级分类. */
	private String type_id;

	private String second_id;
	private String third_id;

	/** 品牌. */
	private String brand_id;

	/** 剂型ID. */
	private String shape_id;

	/** 之类ID. */
	private String kind_id;

	/** 仓库ID. */
	private String wh_id;

	/** 规格对象. */
	private FormatDto formatDto;

	private double prod_discount;

	/** 批准文号. */
	private String prod_certno;

	/** 药品禁忌. */
	private String prod_taboo;

	/** 生成日期. */
	private String prod_date;

	/** 保质期. */
	private String prod_keepdate;

	/** 储藏. */
	private String prod_storage;

	/** 功能主治. */
	private String prod_function;

	private String prod_usage;
	private String prod_chengfen;
	private String prod_bad;
	private String prod_chandi;
	private int prod_xl;
	private String format_id;

	private FormatDto fromats;

	/** 图片对象. */
	private ImgDto imgDto;
	private String img_id;
	private String toindex;

	private String prod_pinyin;// 拼音
	private String prod_firstABC;// 首字母
	private String prod_commonName;// 通用名称
	private String imgSrcs;
	private List<String> formats;
	private List<String> packs;
	private List<BigDecimal> prices;
	private List<Integer> sku;
	private Integer priceOrderBy;// 排序识别，0按价格降序；1按价格升序；
	private Integer xlOrderBy;// 0按销量降序；1按销量升序

	private String prod_format;
	private String prod_pack;
	private BigDecimal prod_price;
	private Integer prod_sku;
	private String prod_unit;
	private String img_src;
	private Integer img_type;

	public String getProd_id() {
		return prod_id;
	}

	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

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

	public String getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(String brand_id) {
		this.brand_id = brand_id;
	}

	public String getShape_id() {
		return shape_id;
	}

	public void setShape_id(String shape_id) {
		this.shape_id = shape_id;
	}

	public String getKind_id() {
		return kind_id;
	}

	public void setKind_id(String kind_id) {
		this.kind_id = kind_id;
	}

	public String getWh_id() {
		return wh_id;
	}

	public void setWh_id(String wh_id) {
		this.wh_id = wh_id;
	}

	public FormatDto getFormatDto() {
		return formatDto;
	}

	public void setFormatDto(FormatDto formatDto) {
		this.formatDto = formatDto;
	}

	public double getProd_discount() {
		return prod_discount;
	}

	public void setProd_discount(double prod_discount) {
		this.prod_discount = prod_discount;
	}

	public String getProd_certno() {
		return prod_certno;
	}

	public void setProd_certno(String prod_certno) {
		this.prod_certno = prod_certno;
	}

	public String getProd_date() {
		return prod_date;
	}

	public void setProd_date(String prod_date) {
		this.prod_date = prod_date;
	}

	public String getProd_keepdate() {
		return prod_keepdate;
	}

	public void setProd_keepdate(String prod_keepdate) {
		this.prod_keepdate = prod_keepdate;
	}

	public String getProd_storage() {
		return prod_storage;
	}

	public void setProd_storage(String prod_storage) {
		this.prod_storage = prod_storage;
	}

	public String getProd_function() {
		return prod_function;
	}

	public void setProd_function(String prod_function) {
		this.prod_function = prod_function;
	}

	public String getProd_usage() {
		return prod_usage;
	}

	public void setProd_usage(String prod_usage) {
		this.prod_usage = prod_usage;
	}

	public String getProd_chengfen() {
		return prod_chengfen;
	}

	public void setProd_chengfen(String prod_chengfen) {
		this.prod_chengfen = prod_chengfen;
	}

	public String getProd_bad() {
		return prod_bad;
	}

	public void setProd_bad(String prod_bad) {
		this.prod_bad = prod_bad;
	}

	public String getProd_chandi() {
		return prod_chandi;
	}

	public void setProd_chandi(String prod_chandi) {
		this.prod_chandi = prod_chandi;
	}

	public int getProd_xl() {
		return prod_xl;
	}

	public void setProd_xl(int prod_xl) {
		this.prod_xl = prod_xl;
	}

	public ImgDto getImgDto() {
		return imgDto;
	}

	public void setImgDto(ImgDto imgDto) {
		this.imgDto = imgDto;
	}

	public String getImg_id() {
		return img_id;
	}

	public void setImg_id(String img_id) {
		this.img_id = img_id;
	}

	public String getToindex() {
		return toindex;
	}

	public void setToindex(String toindex) {
		this.toindex = toindex;
	}

	public String getProd_pinyin() {
		return prod_pinyin;
	}

	public void setProd_pinyin(String prod_pinyin) {
		this.prod_pinyin = prod_pinyin;
	}

	public String getProd_firstABC() {
		return prod_firstABC;
	}

	public void setProd_firstABC(String prod_firstABC) {
		this.prod_firstABC = prod_firstABC;
	}

	public String getProd_commonName() {
		return prod_commonName;
	}

	public void setProd_commonName(String prod_commonName) {
		this.prod_commonName = prod_commonName;
	}

	public String getImgSrcs() {
		return imgSrcs;
	}

	public void setImgSrcs(String imgSrcs) {
		this.imgSrcs = imgSrcs;
	}

	public List<String> getFormats() {
		return formats;
	}

	public void setFormats(List<String> formats) {
		this.formats = formats;
	}

	public List<String> getPacks() {
		return packs;
	}

	public void setPacks(List<String> packs) {
		this.packs = packs;
	}

	public List<BigDecimal> getPrices() {
		return prices;
	}

	public void setPrices(List<BigDecimal> prices) {
		this.prices = prices;
	}

	public List<Integer> getSku() {
		return sku;
	}

	public void setSku(List<Integer> sku) {
		this.sku = sku;
	}

	public String getFormat_id() {
		return format_id;
	}

	public void setFormat_id(String format_id) {
		this.format_id = format_id;
	}

	public String getProd_taboo() {
		return prod_taboo;
	}

	public void setProd_taboo(String prod_taboo) {
		this.prod_taboo = prod_taboo;
	}

	public Integer getPriceOrderBy() {
		return priceOrderBy;
	}

	public void setPriceOrderBy(Integer priceOrderBy) {
		this.priceOrderBy = priceOrderBy;
	}

	public Integer getXlOrderBy() {
		return xlOrderBy;
	}

	public void setXlOrderBy(Integer xlOrderBy) {
		this.xlOrderBy = xlOrderBy;
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

	public Integer getProd_sku() {
		return prod_sku;
	}

	public void setProd_sku(Integer prod_sku) {
		this.prod_sku = prod_sku;
	}

	public String getProd_unit() {
		return prod_unit;
	}

	public void setProd_unit(String prod_unit) {
		this.prod_unit = prod_unit;
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

	public FormatDto getFromats() {
		return fromats;
	}

	public void setFromats(FormatDto fromats) {
		this.fromats = fromats;
	}

}
