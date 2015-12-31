package com.jiuyi.yao.service.discuss.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.yao.common.dict.CacheContainer;
import com.jiuyi.yao.common.dict.Constants;
import com.jiuyi.yao.common.util.Util;
import com.jiuyi.yao.dao.discuss.DiscussDao;
import com.jiuyi.yao.dao.order.OrderDao;
import com.jiuyi.yao.dto.common.ResponseDto;
import com.jiuyi.yao.dto.common.TokenDto;
import com.jiuyi.yao.dto.customer.CustomerDto;
import com.jiuyi.yao.dto.discuss.DiscussDto;
import com.jiuyi.yao.dto.order.OrderDto;
import com.jiuyi.yao.service.BusinessException;
import com.jiuyi.yao.service.discuss.DiscussService;

/**
 * @author superb    @Date 2015年12月31日
 * 
 * @Description 
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
@Service
public class DiscussServiceImpl implements DiscussService {

	@Autowired
	private DiscussDao discussDao;

	@Autowired
	private OrderDao orderDao;

	/**
	 * 
	 * @number	1		@description	添加评论
	 * 
	 * @param discussDto
	 * @throws Exception
	 *
	 * @Date 2015年12月31日
	 */
	@Override
	public ResponseDto addDiscuss(DiscussDto discussDto) throws Exception {
		if (discussDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}
		if (!Util.isNotEmpty(discussDto.getOrder_id())) {
			throw new BusinessException("请选择要评价的订单id");
		}
		if (!Util.isNotEmpty(discussDto.getDis_mess())) {
			throw new BusinessException("请输入评价内容");
		}
		if (discussDto.getProd_score() == null) {
			throw new BusinessException("请输入商品评分");
		}
		if (discussDto.getService_score() == null) {
			throw new BusinessException("请输入服务评分");
		}
		if (discussDto.getSpeed_score() == null) {
			throw new BusinessException("请输入发货速度评分");
		}
		if (discussDto.getTrans_score() == null) {
			throw new BusinessException("请输入物流评分");
		}

		TokenDto tokenDto = CacheContainer.getToken(discussDto.getToken());
		CustomerDto cust = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();

		// 查询订单
		OrderDto orderDto = new OrderDto();
		orderDto.setOrder_id(discussDto.getOrder_id());
		List<OrderDto> order = orderDao.queryOrder(orderDto);
		if (order == null || order.isEmpty() || order.size() == 0) {
			throw new BusinessException("订单不存在");
		}
		if (order.get(0).getDiscussStatus() == 1) {
			throw new BusinessException("订单已评价");
		}

		discussDto.setProd_id(order.get(0).getProd_id());
		discussDto.setUser_id(cust.getUser_id());

		// 添加评论
		discussDto.setDis_id(Util.getUniqueSn());
		discussDao.insertDiscuss(discussDto);

		// 更改订单
		orderDto.setDiscussStatus(1);
		orderDao.updateOrder(orderDto);

		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultDesc("评论成功");
		return responseDto;
	}

	/**
	 * 
	 * @number	2		@description	查询评论
	 * 
	 * @param discussDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月31日
	 */
	@Override
	public ResponseDto queryDiscuss(DiscussDto discussDto) throws Exception {
		if (discussDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}
		if (!Util.isNotEmpty(discussDto.getProd_id())) {
			throw new BusinessException("商品id不能为空");
		}
		List<DiscussDto> discuss = discussDao.productDiscuss(discussDto);

		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultDesc("商品评论");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", discuss);
		responseDto.setDetail(map);
		return responseDto;
	}
}
