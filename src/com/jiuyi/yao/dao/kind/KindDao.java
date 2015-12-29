package com.jiuyi.yao.dao.kind;

import java.util.List;

import com.jiuyi.yao.dto.kind.KindDto;

/**
 * @author superb @Date 2015年12月17日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface KindDao {
	/**
	 * 
	 * @number 1 @description 根据一级分类ID查询二级列表
	 * 
	 * @param kingDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月17日
	 */
	public List<KindDto> querySecondListByTypeId(KindDto kindDto) throws Exception;

	/**
	 * 
	 * @number 2 @description 根据二级ID查询三级列表
	 * 
	 * @param kindDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月17日
	 */
	public List<KindDto> queryThirdListBySecondId(KindDto kindDto) throws Exception;

	/**
	 * 
	 * @number 3 @description 查询一级列表
	 * 
	 * @param kindDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月18日
	 */
	public List<KindDto> queryTypeList(KindDto kindDto) throws Exception;
}
