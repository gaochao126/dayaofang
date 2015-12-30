package com.jiuyi.yao.service.order;

import com.jiuyi.yao.dto.common.ResponseDto;
import com.jiuyi.yao.dto.order.OrderDto;

/**
 * @description 第三方支付订单业务层接口
 * @author zhb
 * @createTime 2015年8月21日
 */
public interface OrderService {

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
	public ResponseDto submitOrder(OrderDto orderDto) throws Exception;

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
	public ResponseDto queryOrder(OrderDto orderDto) throws Exception;

	/**
	 * @description 创建微信支付订单
	 * @param thirdPayOrderDto
	 * @return
	 * @throws Exception
	 */
	public ResponseDto createWeixinPayOrder(OrderDto orderDto) throws Exception;

	/**
	 * @description 根据微信支付返回的XML更新微信订单状态
	 * @param respXml
	 * @throws Exception
	 */
	public void updateWeixinOrderByRespXml(String respXml) throws Exception;

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
	public ResponseDto requestRefund(OrderDto orderDto) throws Exception;

	/**
	 * 
	 * @number @description 退款处理
	 * 
	 * @param thirdPayOrderDto
	 * @throws Exception
	 *
	 * @Date 2015年12月15日
	 */
	public void refund(OrderDto orderDto) throws Exception;

}