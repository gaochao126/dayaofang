package com.jiuyi.yao.service.order.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.yao.common.dict.CacheContainer;
import com.jiuyi.yao.common.dict.Constants;
import com.jiuyi.yao.common.util.HttpsUtil;
import com.jiuyi.yao.common.util.MD5;
import com.jiuyi.yao.common.util.SysCfg;
import com.jiuyi.yao.common.util.Util;
import com.jiuyi.yao.dao.address.AddressDao;
import com.jiuyi.yao.dao.order.OrderDao;
import com.jiuyi.yao.dao.refund.RefundDao;
import com.jiuyi.yao.dao.shopcar.ShopCarDao;
import com.jiuyi.yao.dto.area.AddressDto;
import com.jiuyi.yao.dto.common.ResponseDto;
import com.jiuyi.yao.dto.common.TokenDto;
import com.jiuyi.yao.dto.customer.CustomerDto;
import com.jiuyi.yao.dto.order.OrderDto;
import com.jiuyi.yao.dto.refund.RefundDto;
import com.jiuyi.yao.dto.shopcar.ShopCarDto;
import com.jiuyi.yao.service.BusinessException;
import com.jiuyi.yao.service.order.OrderService;

/**
 * @description 第三方支付订单业务层实现
 * @author zhb
 * @createTime 2015年8月21日
 */
@Service
public class OrderServiceImpl implements OrderService {
	private final static Logger logger = Logger.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private ShopCarDao shopCarDao;

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private RefundDao refundDao;

	/**
	 * 
	 * @number 1 @description 提交订单
	 * 
	 * @param orderDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月29日
	 */
	@Override
	public ResponseDto submitOrder(OrderDto orderDto) throws Exception {
		if (orderDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		if (orderDto.getCarIds() == null || orderDto.getCarIds().isEmpty()) {
			throw new BusinessException("请传入购物车id集合");
		}

		TokenDto tokenDto = CacheContainer.getToken(orderDto.getToken());
		CustomerDto cust = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();

		orderDto.setUser_id(cust.getUser_id());

		// 查询购物车
		List<ShopCarDto> cars = shopCarDao.querySomeShopCar(orderDto.getCarIds());
		// 查询收货地址
		AddressDto addressDto = new AddressDto();
		addressDto.setAddr_id(orderDto.getAddr_id());
		List<AddressDto> addrs = addressDao.queryUserAddress(addressDto);
		if (addrs == null || addrs.isEmpty() || addrs.size() == 0) {
			throw new BusinessException("地址不存在");
		}
		String receiverAddr = addrs.get(0).getAddr_provence() + " " + addrs.get(0).getAddr_city() + " " + addrs.get(0).getAddr_country() + " " + addrs.get(0).getAddr_stree() + " 邮编：" + addrs.get(0).getAddr_mail() + " 收货人电话：" + addrs.get(0).getPhone() + " 收货人姓名：" + addrs.get(0).getPerson_name();
		// 生成订单编号
		String outTradeNo = Util.getUniqueSn();

		/** 设置总额. */
		BigDecimal totalAmount = new BigDecimal(0);

		for (int i = 0; i < cars.size(); i++) {
			OrderDto order = new OrderDto();
			order.setOrder_id(cars.get(i).getCar_id());
			order.setUser_id(orderDto.getUser_id());
			order.setProd_id(cars.get(i).getProd_id());
			order.setFormat_id(cars.get(i).getFormat_id());
			order.setOutTradeNo(outTradeNo);
			order.setOrderType(0);
			order.setCreateTime(new Date());
			order.setBuy_count(cars.get(i).getBuy_count());
			order.setReceiverWay(orderDto.getReceiverWay());
			order.setReceiverAddr(receiverAddr);
			order.setOrderMess(orderDto.getOrderMess());
			order.setPayAmount(cars.get(i).getProd_price().multiply(new BigDecimal(cars.get(i).getBuy_count())));// 设置小计
			totalAmount.add(order.getPayAmount());
			orderDao.insertOrder(order);
			System.out.println("添加成功一个");
		}

		// 删除购物车
		shopCarDao.deleteShopCarBySomeCarId(orderDto.getCarIds());

		ResponseDto responseDto = new ResponseDto();
		responseDto.setDetail(outTradeNo);
		responseDto.setResultDesc("提交订单成功");
		return responseDto;
	}

	/**
	 * 
	 * @number	2		@description 查询订单
	 * 
	 * @param orderDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月30日
	 */
	@Override
	public ResponseDto queryOrder(OrderDto orderDto) throws Exception {
		if (orderDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		TokenDto tokenDto = CacheContainer.getToken(orderDto.getToken());
		CustomerDto cust = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();

		orderDto.setUser_id(cust.getUser_id());

		List<OrderDto> orders = orderDao.queryOrder(orderDto);

		ResponseDto responseDto = new ResponseDto();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", orders);
		responseDto.setDetail(map);
		responseDto.setResultDesc("我的订单");
		return responseDto;
	}

	/**
	 * @description 创建微信支付订单
	 * @param thirdPayOrderDto
	 * @return
	 * @throws Exception
	 */
	@Override
	public ResponseDto createWeixinPayOrder(OrderDto orderDto) throws Exception {
		if (orderDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}
		return createProductOrder(orderDto);
	}

	/**
	 * @description 创建订单
	 * @param thirdPayOrderDto
	 * @return
	 * @throws Exception
	 */
	private ResponseDto createProductOrder(OrderDto orderDto) throws Exception {
		if (orderDto.getOutTradeNo() == null) {
			throw new BusinessException("outTradeNo不能为空");
		}

		TokenDto token = CacheContainer.getToken(orderDto.getToken());
		CustomerDto customer = token != null ? token.getCustomerDto() : new CustomerDto();
		if (!Util.isNotEmpty(customer.getUser_id())) {
			throw new BusinessException("登录异常");
		}

		orderDto.setUser_id(customer.getUser_id());
		// 查询订单
		List<OrderDto> orders = orderDao.queryOrder(orderDto);

		/** 设置总额. */
		BigDecimal totalAmount = new BigDecimal(0);

		// 判断订单是否为可待支付状态
		for (int i = 0; i < orders.size(); i++) {
			totalAmount.add(orders.get(i).getPayAmount());
			if (orders.get(i).getOrderStatus() != 0) {
				throw new BusinessException("您的订单中存在已支付的商品");
			}
		}

		if (Util.isNotEmpty(orderDto.getWeixinOpenid())) {// 微信客户端
			orderDto.setClientType(0);
		} else { // 微信APP客户端
			orderDto.setClientType(1);
		}

		/** 设置微信预支付ID. */
		orderDto.setTotalAmount(totalAmount);
		setWeixinPrepayid(orderDto, "791大药房");

		// 更新预支付id,客户端类型
		orderDao.updateOrder(orderDto);

		// 返回结果
		ResponseDto responseDto = new ResponseDto();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("prepayId", orderDto.getPrepayId());
		map.put("outTradeNo", orderDto.getOutTradeNo());
		if (Util.isNotEmpty(orderDto.getPayParams())) {
			map.put("paySign", MD5.getMD5Code(orderDto.getPayParams().replace("?", orderDto.getPrepayId()) + "&key=" + SysCfg.getString("weixin.pay.key")));
		}
		responseDto.setResultDesc("创建成功");
		responseDto.setDetail(map);
		return responseDto;
	}

	/**
	 * @description 根据微信支付返回的XML更新微信订单状态
	 * @param respXml
	 * @throws Exception
	 */
	@Override
	public void updateWeixinOrderByRespXml(String respXml) throws Exception {
		/** 解析数据. */
		Document doc = DocumentHelper.parseText(respXml);
		List<?> elements = doc.getRootElement().elements();
		Map<String, String> respMap = new HashMap<String, String>();
		for (Object et : elements) {
			respMap.put(((Element) et).getName(), ((Element) et).getText());
		}

		/** 支付失败时什么也不做. */
		if (respMap == null || !"SUCCESS".equals(respMap.get("return_code"))) {
			return;
		}

		/** 获取订单详情. */
		OrderDto orderDto = new OrderDto();
		orderDto.setOutTradeNo(respMap.get("out_trade_no"));
		List<OrderDto> orders = orderDao.queryOrder(orderDto);

		if (orders == null || orders.isEmpty() || orders.size() == 0) {
			return;
		}
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderStatus() == 1) {
				return;
			}
		}

		/** 更新订单. */
		orderDto.setTransactionId(respMap.get("transaction_id"));
		orderDto.setPayTime(new Date());
		orderDto.setPayBank(respMap.get("bank_type"));
		orderDto.setOrderStatus(1);
		orderDao.updateOrder(orderDto);
	}

	/**
	 * @description 获取微信预支付ID
	 * @param thirdPayOrderDto
	 * @return
	 * @throws DocumentException
	 * @throws BusinessException
	 */
	public void setWeixinPrepayid(OrderDto orderDto, String desc) throws Exception {
		Map<String, String> reqMap = new HashMap<String, String>();
		orderDto.setOutTradeNo(orderDto.getOutTradeNo());
		reqMap.put("appid", SysCfg.getString("weixin.appid")); // 公众账号ID
		reqMap.put("mch_id", SysCfg.getString("weixin.mch_id"));// 商户号
		reqMap.put("nonce_str", MD5.getMD5Code(Util.getUniqueSn()));// 随机字符串
		reqMap.put("body", desc);// 商品描述
		reqMap.put("out_trade_no", orderDto.getOutTradeNo()); // 商户订单号
		reqMap.put("total_fee", (int) (orderDto.getTotalAmount().doubleValue() * 100) + "");// 总金额
		reqMap.put("spbill_create_ip", orderDto.getIpAddr()); // 终端IP
		reqMap.put("notify_url", SysCfg.getString("weixin.pay.notify"));// 通知地址
		if (Util.isNotEmpty(orderDto.getWeixinOpenid())) {// 微信公众号支付
			reqMap.put("trade_type", "JSAPI");// 交易类型
			reqMap.put("openid", orderDto.getWeixinOpenid()); // 用户标识
		} else { // 微信APP支付
			reqMap.put("appid", SysCfg.getString("app.appid")); // 公众账号ID
			reqMap.put("mch_id", SysCfg.getString("app.mch_id"));// 商户号
			reqMap.put("trade_type", "APP");// 交易类型
		}

		/** reqMap的key值排序. */
		List<String> mapKeys = new ArrayList<String>();
		for (String key : reqMap.keySet()) {
			mapKeys.add(key);
		}
		Collections.sort(mapKeys);

		/** 生成签名. */
		StringBuffer sb = new StringBuffer();
		for (String key : mapKeys) {
			sb.append(key + "=" + reqMap.get(key) + "&");
		}
		sb.append("key=" + SysCfg.getString("weixin.pay.key"));
		String sign = MD5.getMD5Code(sb.toString());

		/** 生成请求xml. */
		String reqXml = "<xml>?</xml>";
		sb = new StringBuffer();
		for (String key : mapKeys) {
			sb.append("<" + key + ">" + reqMap.get(key) + "</" + key + ">\n");
		}
		sb.append("<sign>" + sign + "</sign>");
		reqXml = reqXml.replace("?", sb.toString());

		/** 请求下服务器,并解析响应结果. */
		String respXml = HttpsUtil.post(SysCfg.getString("weixin.unifiedorder"), reqXml);
		logger.info("OrderServiceImpl.setWeixinPrepayid###" + respXml);
		Document doc = DocumentHelper.parseText(respXml);
		List<?> elements = doc.getRootElement().elements();
		Map<String, String> respMap = new HashMap<String, String>();
		for (Object et : elements) {
			respMap.put(((Element) et).getName(), ((Element) et).getText());
		}
		if (!Util.isNotEmpty(respMap.get("prepay_id"))) {
			throw new BusinessException(respMap.get("return_msg"));
		}
		orderDto.setPrepayId(respMap.get("prepay_id"));
	}

	/**
	 * 
	 * @number @description 退款申请
	 * 
	 * @param thirdPayOrderDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月15日
	 */
	@Override
	public ResponseDto requestRefund(OrderDto orderDto) throws Exception {
		// 退款处理
		refund(orderDto);

		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultDesc("退款成功");
		return responseDto;
	}

	/**
	 * 
	 * @number @description 退款处理
	 * 
	 * @param thirdPayOrderDto
	 * @throws Exception
	 *
	 * @Date 2015年12月15日
	 */
	@Override
	public void refund(OrderDto orderDto) throws Exception {
		/** step1: 空判断 */
		if (orderDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		/** step2: 获取用户 */
		TokenDto token = CacheContainer.getToken(orderDto.getToken());
		CustomerDto customer = token != null ? token.getCustomerDto() : new CustomerDto();
		if (!Util.isNotEmpty(customer.getUser_id())) {
			throw new BusinessException("登录异常");
		}
		orderDto.setUser_id(customer.getUser_id());

		/** step2:校验订单号 */
		if (!Util.isNotEmpty(orderDto.getOutTradeNo())) {
			throw new BusinessException("订单id不能为空");
		}

		/** step3:查询订单 */
		List<OrderDto> order = orderDao.queryOrder(orderDto);
		if (order == null || order.isEmpty() || order.size() == 0) {
			throw new BusinessException("订单不存在");
		}

		/** 设置总额. */
		BigDecimal totalAmount = new BigDecimal(0);

		for (int i = 0; i < order.size(); i++) {
			totalAmount.add(order.get(i).getPayAmount());
			if (order.get(i).getOrderStatus() == 0) {
				throw new BusinessException("该订单存在未支付商品");
			}

			/** step4:校验订单本人 */
			if (order.get(i).getUser_id() != orderDto.getUser_id()) {
				throw new BusinessException("该订单存在不属于您的订单");
			}
		}

		// 添加退款申请记录
		String outRefundNo = Util.getUniqueSn();
		RefundDto refundDto = new RefundDto();
		refundDto.setId(outRefundNo);
		refundDto.setOutTradeNo(orderDto.getOutTradeNo());
		refundDto.setStatus(1);// 设置退款状态为申请退款中
		refundDao.insertRefund(refundDto);

		// 更改订单状态为申请退款
		orderDto.setRefundStatus(1);// 设置订单状态为申请退款
		orderDao.updateOrder(orderDto);

		/** step6:校验是否使用现金 */
		if (totalAmount != null) {
			Map<String, String> reqMap = new HashMap<String, String>();
			reqMap.put("nonce_str", MD5.getMD5Code(Util.getUniqueSn()));// 随机字符串
			reqMap.put("out_trade_no", orderDto.getOutTradeNo()); // 商户订单号
			reqMap.put("out_refund_no", refundDto.getId());// 商户退款编号
			reqMap.put("total_fee", totalAmount + "");// 总金额
			reqMap.put("refund_fee", totalAmount.doubleValue() * 100 + "");// 退款金额
			reqMap.put("op_user_id", SysCfg.getString("")); // 终端IP

			if (order.get(0).getClientType() == 0) {// 微信公众号支付
				reqMap.put("mch_id", SysCfg.getString("weixin.mch_id"));// 商户号
				reqMap.put("op_user_id", SysCfg.getString("weixin.mch_id"));// 操作员
				reqMap.put("appid", SysCfg.getString("weixin.appid")); // 公众账号ID
			} else { // 微信APP支付
				reqMap.put("mch_id", SysCfg.getString("app.mch_id"));// 商户号
				reqMap.put("op_user_id", SysCfg.getString("app.mch_id"));// 操作员
				reqMap.put("appid", SysCfg.getString("app.appid")); // 公众账号ID
			}

			/** reqMap的key值排序. */
			List<String> mapKeys = new ArrayList<String>();
			for (String key : reqMap.keySet()) {
				mapKeys.add(key);
			}
			Collections.sort(mapKeys);

			/** 生成签名. */
			StringBuffer sb = new StringBuffer();
			for (String key : mapKeys) {
				sb.append(key + "=" + reqMap.get(key) + "&");
			}
			sb.append("key=" + SysCfg.getString("weixin.pay.key"));
			String sign = MD5.getMD5Code(sb.toString());

			/** 生成请求xml. */
			String reqXml = "<xml>?</xml>";
			sb = new StringBuffer();
			for (String key : mapKeys) {
				sb.append("<" + key + ">" + reqMap.get(key) + "</" + key + ">\n");
			}
			sb.append("<sign>" + sign + "</sign>");
			reqXml = reqXml.replace("?", sb.toString());

			/** 请求下服务器,并解析响应结果. */
			String respXml = HttpsUtil.post(SysCfg.getString("weixin.refund"), reqXml);
			Document doc = DocumentHelper.parseText(respXml);
			List<?> elements = doc.getRootElement().elements();
			Map<String, String> respMap = new HashMap<String, String>();
			for (Object et : elements) {
				respMap.put(((Element) et).getName(), ((Element) et).getText());
			}

			// 判断结果
			if (!respMap.get("return_code").equals("SUCCESS")) {
				logger.info("ThirdPayOrderServiceImpl.refund==>return_code:" + respMap.get("return_code"));
				throw new BusinessException(respMap.get("return_msg"));
			}

			// 退款成功后，更新退款记录状态
			refundDto.setEndTime(new Date());
			refundDto.setId(respMap.get("out_refund_no"));
			refundDto.setStatus(1);
			refundDao.updateRefund(refundDto);

			// 退款成功后，更新订单状态为退款成功
			orderDto.setRefundStatus(2);
			orderDao.updateOrder(orderDto);
		}
	}
}