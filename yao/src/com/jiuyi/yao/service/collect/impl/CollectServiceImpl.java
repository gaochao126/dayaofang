package com.jiuyi.yao.service.collect.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.yao.common.dict.CacheContainer;
import com.jiuyi.yao.common.dict.Constants;
import com.jiuyi.yao.common.util.Enumerate;
import com.jiuyi.yao.common.util.Util;
import com.jiuyi.yao.dao.collect.CollectDao;
import com.jiuyi.yao.dto.collect.CollectDto;
import com.jiuyi.yao.dto.common.ResponseDto;
import com.jiuyi.yao.dto.common.TokenDto;
import com.jiuyi.yao.dto.customer.CustomerDto;
import com.jiuyi.yao.service.BusinessException;
import com.jiuyi.yao.service.collect.CollectService;

/**
 * @author superb    @Date 2016年1月7日
 * 
 * @Description 
 *
 * @Copyright 2016 重庆柒玖壹健康管理有限公司
 */
@Service
public class CollectServiceImpl implements CollectService {

	@Autowired
	private CollectDao collectDao;

	/**
	 * 
	 * @number	1		@description	添加收藏
	 * 
	 * @param collectDto
	 * @throws Exception
	 *
	 * @Date 2016年1月7日
	 */
	@Override
	public ResponseDto addCollect(CollectDto collectDto) throws Exception {
		if (collectDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}
		if (!Util.isNotEmpty(collectDto.getProd_id())) {
			throw new BusinessException("请选择商品id");
		}
		if (!Util.isNotEmpty(collectDto.getFormat_id())) {
			throw new BusinessException("请选择规格id");
		}

		TokenDto tokenDto = CacheContainer.getToken(collectDto.getToken());
		CustomerDto cust = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();

		collectDto.setUser_id(cust.getUser_id());

		collectDto.setColl_id(Util.getUniqueSn());

		// 查询该商品是否被收藏
		List<CollectDto> collects = collectDao.queryCollect(collectDto);
		if (collects != null && !collects.isEmpty() && collects.size() > 0) {
			return new ResponseDto(2, "该商品已被收藏", null);
		}

		collectDao.addCollect(collectDto);

		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultDesc("添加成功");
		return responseDto;
	}

	/**
	 * 
	 * @number	2		@description	查询收藏
	 * 
	 * @param collectDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2016年1月7日
	 */
	@Override
	public ResponseDto queryCollect(CollectDto collectDto) throws Exception {
		if (collectDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		TokenDto tokenDto = CacheContainer.getToken(collectDto.getToken());
		CustomerDto cust = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();

		collectDto.setUser_id(cust.getUser_id());

		List<CollectDto> collects = collectDao.queryCollect(collectDto);

		for (int i = 0; i < collects.size(); i++) {
			if (Util.isNotEmpty(collects.get(i).getImg_src())) {
				collects.get(i).setImg_src(Enumerate.IMG_SRC + collects.get(i).getImg_src());
			}
		}

		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultDesc("我的收藏");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", collects);
		responseDto.setDetail(map);
		return responseDto;
	}

	/**
	 * 
	 * @number	3		@description	删除收藏
	 * 
	 * @param collectDto
	 * @throws Exception
	 *
	 * @Date 2016年1月7日
	 */
	@Override
	public ResponseDto deleteCollect(CollectDto collectDto) throws Exception {
		if (collectDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		if (!Util.isNotEmpty(collectDto.getColl_id())) {
			throw new BusinessException("请输入收藏id");
		}
		TokenDto tokenDto = CacheContainer.getToken(collectDto.getToken());
		CustomerDto cust = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();

		collectDto.setUser_id(cust.getUser_id());

		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultDesc("删除成功");
		return responseDto;
	}
}
