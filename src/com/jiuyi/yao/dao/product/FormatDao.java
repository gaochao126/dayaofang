package com.jiuyi.yao.dao.product;

import java.util.List;

import com.jiuyi.yao.dto.product.FormatDto;

/**
 * @author superb @Date 2015年12月24日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface FormatDao {
	/**
	 * 
	 * @number 1 @description 查询规格集合
	 * 
	 * @param formatDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月24日
	 */
	public List<FormatDto> queryFormatByProductId(FormatDto formatDto) throws Exception;

	/**
	 * 
	 * @number 2 @description 减少库存
	 * 
	 * @param formatDto
	 * @throws Exception
	 *
	 * @Date 2015年12月25日
	 */
	public void updateSkuDown(FormatDto formatDto) throws Exception;
}
