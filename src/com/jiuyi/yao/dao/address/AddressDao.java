package com.jiuyi.yao.dao.address;

import java.util.List;

import com.jiuyi.yao.dto.area.AddressDto;
import com.jiuyi.yao.dto.area.AreaDto;

/**
 * @author superb @Date 2015年12月23日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface AddressDao {
	/**
	 * 
	 * @number 1 @description 查询省份
	 * 
	 * @param areaDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月23日
	 */
	public List<AreaDto> queryProvice(AreaDto areaDto) throws Exception;

	/**
	 * 
	 * @number 2 @description 查询市
	 * 
	 * @param areaDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月23日
	 */
	public List<AreaDto> queryCityByProvince(AreaDto areaDto) throws Exception;

	/**
	 * 
	 * @number 3 @description 查询区县
	 * 
	 * @param areaDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月23日
	 */
	public List<AreaDto> queryTownByCity(AreaDto areaDto) throws Exception;

	/**
	 * 
	 * @number	4		@description 添加地址
	 * 
	 * @param addressDto
	 * @throws Exception
	 *
	 * @Date 2015年12月30日
	 */
	public void addAddress(AddressDto addressDto) throws Exception;

	/**
	 * 
	 * @number	5		@description 修改地址
	 * 
	 * @param addressDto
	 * @throws Exception
	 *
	 * @Date 2015年12月30日
	 */
	public void updateAddress(AddressDto addressDto) throws Exception;

	/**
	 * 
	 * @number	6		@description 查询个人地址
	 * 
	 * @param addressDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月30日
	 */
	public List<AddressDto> queryUserAddress(AddressDto addressDto) throws Exception;
}
