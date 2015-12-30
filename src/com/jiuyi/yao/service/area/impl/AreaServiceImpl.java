package com.jiuyi.yao.service.area.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.yao.common.dict.CacheContainer;
import com.jiuyi.yao.common.dict.Constants;
import com.jiuyi.yao.common.util.Util;
import com.jiuyi.yao.dao.address.AddressDao;
import com.jiuyi.yao.dto.area.AddressDto;
import com.jiuyi.yao.dto.area.AreaDto;
import com.jiuyi.yao.dto.common.ResponseDto;
import com.jiuyi.yao.dto.common.TokenDto;
import com.jiuyi.yao.dto.customer.CustomerDto;
import com.jiuyi.yao.service.BusinessException;
import com.jiuyi.yao.service.area.AreaService;

/**
 * @author superb @Date 2015年12月24日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
@Service
public class AreaServiceImpl implements AreaService {
	@Autowired
	private AddressDao addressDao;
	/** 省份缓存. */
	public static List<AreaDto> provinces = new ArrayList<AreaDto>();

	/** 省-市缓存. */
	public static Map<Integer, List<AreaDto>> no_city = new ConcurrentHashMap<Integer, List<AreaDto>>();

	/** 市-区县缓存. */
	public static Map<Integer, List<AreaDto>> no_town = new ConcurrentHashMap<Integer, List<AreaDto>>();

	/**
	 * 
	 * @number @description 查询级联省列表
	 * 
	 * @param areaDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月23日
	 */
	@Override
	public ResponseDto queryProvinceCascade(AreaDto areaDto) throws Exception {
		List<AreaDto> areas = getProvince();
		ResponseDto responseDto = new ResponseDto();
		Map<String, List<AreaDto>> map = new HashMap<String, List<AreaDto>>();
		map.put("list", areas);
		responseDto.setDetail(map);
		responseDto.setResultDesc("省份列表");
		return responseDto;
	}

	/**
	 * 
	 * @number @description 查询级联市列表
	 * 
	 * @param areaDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月23日
	 */
	@Override
	public ResponseDto queryCityByProvinceCascade(AreaDto areaDto) throws Exception {
		if (areaDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}
		if (areaDto.getNo() == null) {
			throw new BusinessException("请填写省份编号");
		}
		List<AreaDto> areas = getCity(areaDto.getNo(), areaDto);
		ResponseDto responseDto = new ResponseDto();
		Map<String, List<AreaDto>> map = new HashMap<String, List<AreaDto>>();
		map.put("list", areas);
		responseDto.setDetail(map);
		responseDto.setResultDesc("城市列表");
		return responseDto;
	}

	/**
	 * 
	 * @number @description 查询级联区县列表
	 * 
	 * @param adreDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月23日
	 */
	@Override
	public ResponseDto queryTownByCityCascade(AreaDto areaDto) throws Exception {
		if (areaDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}
		if (areaDto.getNo() == null) {
			throw new BusinessException("请填写城市编号");
		}
		List<AreaDto> areas = getTown(areaDto.getNo(), areaDto);
		ResponseDto responseDto = new ResponseDto();
		Map<String, List<AreaDto>> map = new HashMap<String, List<AreaDto>>();
		map.put("list", areas);
		responseDto.setDetail(map);
		responseDto.setResultDesc("区县列表");
		return responseDto;
	}

	/**
	 * 
	 * @number @description 获得省
	 * 
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月23日
	 */
	public List<AreaDto> getProvince() throws Exception {
		if (provinces.isEmpty()) {
			AreaDto areaDto = new AreaDto();
			provinces = addressDao.queryProvice(areaDto);
		}
		return provinces;
	}

	/**
	 * 
	 * @number @description 获得市
	 * 
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月23日
	 */
	public List<AreaDto> getCity(Integer no, AreaDto areaDto) throws Exception {
		if (!no_city.containsKey(no)) {
			List<AreaDto> areas = addressDao.queryCityByProvince(areaDto);
			no_city.put(no, areas);
			return areas;
		}
		return no_city.get(no);
	}

	/**
	 * 
	 * @number @description 查询区县
	 * 
	 * @param no
	 * @param areaDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月23日
	 */
	public List<AreaDto> getTown(Integer no, AreaDto areaDto) throws Exception {
		if (!no_town.containsKey(no)) {
			List<AreaDto> areas = addressDao.queryTownByCity(areaDto);
			no_town.put(no, areas);
			return areas;
		}
		return no_town.get(no);
	}

	/**
	 * 
	 * @number			@description 添加地址
	 * 
	 * @param addressDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月30日
	 */
	@Override
	public ResponseDto addAddress(AddressDto addressDto) throws Exception {
		if (addressDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		if (!Util.isNotEmpty(addressDto.getAddr_provence())) {
			throw new BusinessException("请选择省份");
		}

		if (!Util.isNotEmpty(addressDto.getAddr_city())) {
			throw new BusinessException("请选择城市");
		}

		if (!Util.isNotEmpty(addressDto.getAddr_country())) {
			throw new BusinessException("请选择区县");
		}

		if (!Util.isNotEmpty(addressDto.getAddr_stree())) {
			throw new BusinessException("请输入街道");
		}

		if (!Util.isNotEmpty(addressDto.getPerson_name())) {
			throw new BusinessException("请输入收货人姓名");
		}

		if (!Util.isNotEmpty(addressDto.getPhone())) {
			throw new BusinessException("请输入收货人手机号");
		}

		if (addressDto.getAddr_status() == null) {
			throw new BusinessException("请指定地址状态1默认，0非默认");
		}

		TokenDto tokenDto = CacheContainer.getToken(addressDto.getToken());
		CustomerDto cust = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();

		if (addressDto.getAddr_status() == 1) {
			AddressDto address = new AddressDto();
			address.setUser_id(cust.getUser_id());
			address.setAddr_status(0);
			addressDao.updateAddress(address);// 修改默认为非默认
		}

		addressDto.setUser_id(cust.getUser_id());
		addressDto.setAddr_id(Util.getUniqueSn());
		addressDto.setDelete_status(1);
		addressDao.addAddress(addressDto);

		ResponseDto responseDto = new ResponseDto();
		responseDto.setDetail(addressDto);
		responseDto.setResultDesc("添加成功");
		return responseDto;
	}

	/**
	 * 
	 * @number			@description 修改地址
	 * 
	 * @param addressDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月30日
	 */
	@Override
	public ResponseDto updateAddress(AddressDto addressDto) throws Exception {
		if (addressDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		if (!Util.isNotEmpty(addressDto.getAddr_id())) {
			throw new BusinessException("请输入地址ID");
		}

		if (!Util.isNotEmpty(addressDto.getAddr_provence())) {
			throw new BusinessException("请选择省份");
		}

		if (!Util.isNotEmpty(addressDto.getAddr_city())) {
			throw new BusinessException("请选择城市");
		}

		if (!Util.isNotEmpty(addressDto.getAddr_country())) {
			throw new BusinessException("请选择区县");
		}

		if (!Util.isNotEmpty(addressDto.getAddr_stree())) {
			throw new BusinessException("请输入街道");
		}

		if (!Util.isNotEmpty(addressDto.getPerson_name())) {
			throw new BusinessException("请输入收货人姓名");
		}

		if (!Util.isNotEmpty(addressDto.getPhone())) {
			throw new BusinessException("请输入收货人手机号");
		}

		if (addressDto.getAddr_status() == null) {
			throw new BusinessException("请指定地址状态1默认，0非默认");
		}

		TokenDto tokenDto = CacheContainer.getToken(addressDto.getToken());
		CustomerDto cust = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();

		if (addressDto.getAddr_status() == 1) {
			AddressDto address = new AddressDto();
			address.setUser_id(cust.getUser_id());
			address.setAddr_status(0);
			addressDao.updateAddress(address);// 修改默认为非默认
		}

		addressDto.setUser_id(cust.getUser_id());
		addressDto.setDelete_status(1);
		addressDao.updateAddress(addressDto);

		ResponseDto responseDto = new ResponseDto();
		responseDto.setDetail(addressDto);
		responseDto.setResultDesc("修改成功");
		return responseDto;
	}

	/**
	 * 
	 * @number			@description	查询地址
	 * 
	 * @param addressDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月30日
	 */
	@Override
	public ResponseDto queryAddress(AddressDto addressDto) throws Exception {
		if (addressDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		TokenDto tokenDto = CacheContainer.getToken(addressDto.getToken());
		CustomerDto cust = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();

		addressDto.setUser_id(cust.getUser_id());

		List<AddressDto> address = addressDao.queryUserAddress(addressDto);
		ResponseDto responseDto = new ResponseDto();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", address);
		responseDto.setDetail(map);
		responseDto.setResultDesc("用户地址");
		return responseDto;
	}

	/**
	 * 
	 * @number			@description 删除地址
	 * 
	 * @param addressDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月30日
	 */
	@Override
	public ResponseDto deleteAddress(AddressDto addressDto) throws Exception {
		if (addressDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		if (!Util.isNotEmpty(addressDto.getAddr_id())) {
			throw new BusinessException("请输入地址ID");
		}

		TokenDto tokenDto = CacheContainer.getToken(addressDto.getToken());
		CustomerDto cust = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();

		addressDto.setUser_id(cust.getUser_id());

		addressDao.deleteAddress(addressDto);

		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultDesc("删除成功");
		return responseDto;
	}
}