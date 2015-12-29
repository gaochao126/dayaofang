package com.jiuyi.yao.service.kind.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.yao.common.util.Util;
import com.jiuyi.yao.dao.kind.KindDao;
import com.jiuyi.yao.dto.common.ResponseDto;
import com.jiuyi.yao.dto.kind.KindDto;
import com.jiuyi.yao.service.BusinessException;
import com.jiuyi.yao.service.kind.KindService;

/**
 * @author superb @Date 2015年12月18日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
@Service
public class KindServiceImpl implements KindService {
	@Autowired
	private KindDao kindDao;

	/** 一级分类缓存. */
	public static List<KindDto> types = new ArrayList<KindDto>();

	/** 二级分类缓存. */
	public static List<KindDto> seconds = new ArrayList<KindDto>();

	/** 三级分类缓存. */
	public static Map<String, List<KindDto>> thirds = new HashMap<String, List<KindDto>>();

	/**
	 * 
	 * @number 1 @description 查询一级分类
	 * 
	 * @param kindDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月18日
	 */
	@Override
	public ResponseDto queryType(KindDto kindDto) throws Exception {
		ResponseDto responseDto = new ResponseDto();
		Map<String, Object> map = new HashMap<String, Object>();

		List<KindDto> kinds = getTypes();
		map.put("list", kinds);
		responseDto.setDetail(map);
		responseDto.setResultDesc("一级分类列表");
		return responseDto;
	}

	/**
	 * 
	 * @number 2 @description 根据一级分类ID查询二级分类
	 * 
	 * @param kindDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月18日
	 */
	@Override
	public ResponseDto querySecondByTypeId(KindDto kindDto) throws Exception {
		ResponseDto responseDto = new ResponseDto();
		Map<String, Object> map = new HashMap<String, Object>();
		List<KindDto> kinds = getSeconds(kindDto);
		map.put("list", kinds);
		responseDto.setDetail(map);
		responseDto.setResultDesc("二级分类列表");
		return responseDto;
	}

	/**
	 * 
	 * @number 3 @description 根据二级ID查询三级分类
	 * 
	 * @param kindDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月18日
	 */
	@Override
	public ResponseDto queryThirdBySecondId(KindDto kindDto) throws Exception {
		if (kindDto == null) {
			throw new BusinessException("数据异常");
		}
		if (!Util.isNotEmpty(kindDto.getSecond_id())) {
			throw new BusinessException("二级分类ID不能为空");
		}

		ResponseDto responseDto = new ResponseDto();
		Map<String, Object> map = new HashMap<String, Object>();
		List<KindDto> kinds = getThirds(kindDto.getSecond_id());
		map.put("list", kinds);
		responseDto.setDetail(map);
		responseDto.setResultDesc("三级分类列表");
		return responseDto;
	}

	/**
	 * 
	 * @number @description 获取一级分类到缓存
	 * 
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月22日
	 */
	public List<KindDto> getTypes() throws Exception {
		if (types.isEmpty()) {
			KindDto kindDto = new KindDto();
			types = kindDao.queryTypeList(kindDto);
			return types;
		} else {
			return types;
		}
	}

	/**
	 * 
	 * @number @description 获取二级分类缓存
	 * 
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月22日
	 */
	public List<KindDto> getSeconds(KindDto kindDto) throws Exception {
		if (seconds.isEmpty()) {
			seconds = kindDao.querySecondListByTypeId(kindDto);
			return seconds;
		} else {
			return seconds;
		}
	}

	/**
	 * 
	 * @number @description 查询三级分类
	 * 
	 * @param secondId
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月24日
	 */
	public List<KindDto> getThirds(String secondId) throws Exception {
		if (!thirds.containsKey(secondId)) {
			KindDto kindDto = new KindDto();
			kindDto.setSecond_id(secondId);
			List<KindDto> kinds = kindDao.queryThirdListBySecondId(kindDto);
			thirds.put(secondId, kinds);
			return kinds;
		} else {
			return thirds.get(secondId);
		}
	}
}
