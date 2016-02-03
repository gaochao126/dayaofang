package com.jiuyi.yao.service.product;

import com.jiuyi.yao.dto.common.ResponseDto;
import com.jiuyi.yao.dto.product.ProductDto;

/**
 * @author superb @Date 2015年12月24日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface ProductService {
	/**
	 * 
	 * @number 1 @description 查询所有药品
	 * 
	 * @param productDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月24日
	 */
	public ResponseDto queryProductList(ProductDto productDto) throws Exception;

	/**
	 * 
	 * @number 2 @description 根据二级分类查询药品
	 * 
	 * @param productDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月24日
	 */
	public ResponseDto queryProductBySecond(ProductDto productDto) throws Exception;

	/**
	 * 
	 * @number 3 @description 根据三级分类查询药品
	 * 
	 * @param productDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月24日
	 */
	public ResponseDto queryProductByThird(ProductDto productDto) throws Exception;

	/**
	 * 
	 * @number 4 @description 搜索商品
	 * 
	 * @param productDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月24日
	 */
	public ResponseDto searchProduct(ProductDto productDto) throws Exception;

	/**
	 * 
	 * @number 5 @description 首页商品
	 * 
	 * @param productDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月24日
	 */
	public ResponseDto queryIndexProductList(ProductDto productDto) throws Exception;

	/**
	 * 
	 * @number	6		@description	去商品详情
	 * 
	 * @param productDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2016年2月3日
	 */
	public ResponseDto prodInfo(ProductDto productDto) throws Exception;

}
