package com.jiuyi.yao.service.discuss;

import com.jiuyi.yao.dto.common.ResponseDto;
import com.jiuyi.yao.dto.discuss.DiscussDto;

/**
 * @author superb    @Date 2015年12月31日
 * 
 * @Description 
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface DiscussService {

	/**
	 * 
	 * @number	1		@description	添加评论
	 * 
	 * @param discussDto
	 * @throws Exception
	 *
	 * @Date 2015年12月31日
	 */
	public ResponseDto addDiscuss(DiscussDto discussDto) throws Exception;

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
	public ResponseDto queryDiscuss(DiscussDto discussDto) throws Exception;
}
