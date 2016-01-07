package com.jiuyi.yao.dto.order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.jiuyi.yao.dto.BaseDto;

/**
 * @author superb @Date 2015年12月29日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public class OrderDto extends BaseDto {

	private static final long serialVersionUID = 6092106362946188193L;
	/** 订单id. */
	private String order_id;
	private String user_id;
	private String prod_id;
	private String format_id;
	/** 订单号. */
	private String outTradeNo;

	private BigDecimal totalAmount;
	private Integer orderType;
	private Date createTime;
	private Date payTime;
	private Integer payType;
	private String payBank;
	private Integer couponId;
	private Date delivTime;
	private String delivWay;
	private Integer receiverWay;
	private String receiverAddr;

	/** 购买数量. */
	private Integer buy_count;

	/** 订单状态. */
	private Integer orderStatus;

	/** 订单留言. */
	private String orderMess;

	/** 评论状态. */
	private Integer discussStatus;

	/** 退款状态. */
	private Integer refundStatus;

	private String prod_name;
	private String prod_commonName;
	private String prod_function;
	private String prod_certno;
	private String prod_chandi;
	private String prod_bad;
	private Integer prod_discount;
	private String prod_usage;
	private String prod_taboo;
	private String prod_format;
	private String prod_pack;
	private BigDecimal prod_price;
	private String img_src;
	private Integer img_type;
	private String ipAddr;
	private Date expiredTime;// 过期时间

	private String addr_id;

	private List<String> orderIds;

	private List<String> carIds;

	private String transactionId;

	private String weixinOpenid;

	private Integer clientType;

	private Integer displayStatus;

	private BigDecimal payAmount;

	private String prepayId;

	/** 应用调用支付接口的参数. */
	private String payParams;

	private Date updateTime;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getProd_id() {
		return prod_id;
	}

	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}

	public String getFormat_id() {
		return format_id;
	}

	public void setFormat_id(String format_id) {
		this.format_id = format_id;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getPayBank() {
		return payBank;
	}

	public void setPayBank(String payBank) {
		this.payBank = payBank;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public Date getDelivTime() {
		return delivTime;
	}

	public void setDelivTime(Date delivTime) {
		this.delivTime = delivTime;
	}

	public String getDelivWay() {
		return delivWay;
	}

	public void setDelivWay(String delivWay) {
		this.delivWay = delivWay;
	}

	public Integer getReceiverWay() {
		return receiverWay;
	}

	public void setReceiverWay(Integer receiverWay) {
		this.receiverWay = receiverWay;
	}

	public String getReceiverAddr() {
		return receiverAddr;
	}

	public void setReceiverAddr(String receiverAddr) {
		this.receiverAddr = receiverAddr;
	}

	public Integer getBuy_count() {
		return buy_count;
	}

	public void setBuy_count(Integer buy_count) {
		this.buy_count = buy_count;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderMess() {
		return orderMess;
	}

	public void setOrderMess(String orderMess) {
		this.orderMess = orderMess;
	}

	public Integer getDiscussStatus() {
		return discussStatus;
	}

	public void setDiscussStatus(Integer discussStatus) {
		this.discussStatus = discussStatus;
	}

	public Integer getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(Integer refundStatus) {
		this.refundStatus = refundStatus;
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

	public String getProd_function() {
		return prod_function;
	}

	public void setProd_function(String prod_function) {
		this.prod_function = prod_function;
	}

	public String getProd_certno() {
		return prod_certno;
	}

	public void setProd_certno(String prod_certno) {
		this.prod_certno = prod_certno;
	}

	public String getProd_chandi() {
		return prod_chandi;
	}

	public void setProd_chandi(String prod_chandi) {
		this.prod_chandi = prod_chandi;
	}

	public String getProd_bad() {
		return prod_bad;
	}

	public void setProd_bad(String prod_bad) {
		this.prod_bad = prod_bad;
	}

	public Integer getProd_discount() {
		return prod_discount;
	}

	public void setProd_discount(Integer prod_discount) {
		this.prod_discount = prod_discount;
	}

	public String getProd_usage() {
		return prod_usage;
	}

	public void setProd_usage(String prod_usage) {
		this.prod_usage = prod_usage;
	}

	public String getProd_taboo() {
		return prod_taboo;
	}

	public void setProd_taboo(String prod_taboo) {
		this.prod_taboo = prod_taboo;
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

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getAddr_id() {
		return addr_id;
	}

	public void setAddr_id(String addr_id) {
		this.addr_id = addr_id;
	}

	public List<String> getOrderIds() {
		return orderIds;
	}

	public void setOrderIds(List<String> orderIds) {
		this.orderIds = orderIds;
	}

	public List<String> getCarIds() {
		return carIds;
	}

	public void setCarIds(List<String> carIds) {
		this.carIds = carIds;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getWeixinOpenid() {
		return weixinOpenid;
	}

	public void setWeixinOpenid(String weixinOpenid) {
		this.weixinOpenid = weixinOpenid;
	}

	public Integer getClientType() {
		return clientType;
	}

	public void setClientType(Integer clientType) {
		this.clientType = clientType;
	}

	public Integer getDisplayStatus() {
		return displayStatus;
	}

	public void setDisplayStatus(Integer displayStatus) {
		this.displayStatus = displayStatus;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public String getPrepayId() {
		return prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}

	public String getPayParams() {
		return payParams;
	}

	public void setPayParams(String payParams) {
		this.payParams = payParams;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(Date expiredTime) {
		this.expiredTime = expiredTime;
	}

}
