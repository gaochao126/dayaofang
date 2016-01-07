package com.jiuyi.yao.service.collect;

import com.jiuyi.yao.dto.collect.CollectDto;
import com.jiuyi.yao.dto.common.ResponseDto;

/**
 * @author superb    @Date 2016年1月7日
 * 
 * @Description 
 *
 * @Copyright 2016 重庆柒玖壹健康管理有限公司
 */
public interface CollectService {
	/**
	 * 
	 * @number	1		@description	添加收藏
	 * 
	 * @param collectDto
	 * @throws Exception
	 *
	 * @Date 2016年1月7日
	 */
	public ResponseDto addCollect(CollectDto collectDto) throws Exception;

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
	public ResponseDto queryCollect(CollectDto collectDto) throws Exception;

	/**
	 * 
	 * @number	3		@description	删除收藏
	 * 
	 * @param collectDto
	 * @throws Exception
	 *
	 * @Date 2016年1月7日
	 */
	public ResponseDto deleteCollect(CollectDto collectDto) throws Exception;
}
