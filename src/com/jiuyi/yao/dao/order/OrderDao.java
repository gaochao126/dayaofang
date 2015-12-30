package com.jiuyi.yao.dao.order;

import java.util.List;

import com.jiuyi.yao.dto.order.OrderDto;

/**
 * @author superb @Date 2015年12月29日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface OrderDao {
	/**
	 * 
	 * @number 1 @description 查询订单
	 * 
	 * @param orderDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月29日
	 */
	public List<OrderDto> queryOrder(OrderDto orderDto) throws Exception;

	/**
	 * 
	 * @number 2 @description 添加订单
	 * 
	 * @param orderDto
	 * @throws Exception
	 *
	 * @Date 2015年12月29日
	 */
	public void insertOrder(OrderDto orderDto) throws Exception;

	/**
	 * 
	 * @number 3 @description 修改订单
	 * 
	 * @param orderDto
	 * @throws Exception
	 *
	 * @Date 2015年12月29日
	 */
	public void updateOrder(OrderDto orderDto) throws Exception;
}
