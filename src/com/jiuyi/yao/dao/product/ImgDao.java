package com.jiuyi.yao.dao.product;

import java.util.List;

import com.jiuyi.yao.dto.product.ImgDto;

/**
 * @author superb @Date 2015年12月24日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface ImgDao {
	/**
	 * 
	 * @number @description
	 * 
	 * @param imgDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月24日
	 */
	List<ImgDto> queryImgByProductId(ImgDto imgDto) throws Exception;
}
