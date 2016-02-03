package com.jiuyi.yao.dao.discuss;

import java.util.List;

import com.jiuyi.yao.dto.discuss.DiscussDto;

/**
 * @author superb    @Date 2015年12月30日
 * 
 * @Description 
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface DiscussDao {
	/**
	 * 
	 * @number	1		@description	添加评论
	 * 
	 * @param discussDto
	 * @throws Exception
	 *
	 * @Date 2015年12月30日
	 */
	public void insertDiscuss(DiscussDto discussDto) throws Exception;

	/**
	 * 
	 * @number	2		@description	查询商品评论
	 * 
	 * @param discussDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月30日
	 */
	public List<DiscussDto> productDiscuss(DiscussDto discussDto) throws Exception;

}
