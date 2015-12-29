package com.jiuyi.yao.service.area;

import com.jiuyi.yao.dto.area.AreaDto;
import com.jiuyi.yao.dto.common.ResponseDto;

/**
 * @author superb @Date 2015年12月24日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface AreaService {
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
	public ResponseDto queryProvinceCascade(AreaDto areaDto) throws Exception;

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
	public ResponseDto queryCityByProvinceCascade(AreaDto areaDto) throws Exception;

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
	public ResponseDto queryTownByCityCascade(AreaDto areaDto) throws Exception;
}
