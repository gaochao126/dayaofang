package com.jiuyi.yao.dao.collect;

import java.util.List;

import com.jiuyi.yao.dto.collect.CollectDto;

/**
 * @author superb    @Date 2016年1月7日
 * 
 * @Description 
 *
 * @Copyright 2016 重庆柒玖壹健康管理有限公司
 */
public interface CollectDao {
	/**
	 * 
	 * @number	1		@description	添加收藏
	 * 
	 * @param collectDto
	 * @throws Exception
	 *
	 * @Date 2016年1月7日
	 */
	public void addCollect(CollectDto collectDto) throws Exception;

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
	public List<CollectDto> queryCollect(CollectDto collectDto) throws Exception;

	/**
	 * 
	 * @number	3		@description	删除收藏
	 * 
	 * @param collectDto
	 * @throws Exception
	 *
	 * @Date 2016年1月7日
	 */
	public void deleteCollect(CollectDto collectDto) throws Exception;
}
