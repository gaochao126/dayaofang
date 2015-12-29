package com.jiuyi.yao.dao.product;

import java.util.List;

import com.jiuyi.yao.dto.product.ProductDto;

/**
 * @author superb @Date 2015年12月23日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface ProductDao {
	/**
	 * 
	 * @number 1 @description 查询所有药品
	 * 
	 * @param productDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月23日
	 */
	public List<ProductDto> queryProductList(ProductDto productDto) throws Exception;

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
	public List<ProductDto> queryProductListBySecond(ProductDto productDto) throws Exception;

	/**
	 * 
	 * @number 3 @description 搜索商品
	 * 
	 * @param productDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月24日
	 */
	public List<ProductDto> searchProduct(ProductDto productDto) throws Exception;

	/**
	 * 
	 * @number 4 @description 根据三级分类查询药品
	 * 
	 * @param productDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月24日
	 */
	public List<ProductDto> queryProductListByThird(ProductDto productDto) throws Exception;

	/**
	 * 
	 * @number 5 @description 查询广告药品
	 * 
	 * @param productDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月24日
	 */
	public List<ProductDto> queryShowProduct(ProductDto productDto) throws Exception;

	/**
	 * 
	 * @number 6 @description 修改销量
	 * 
	 * @param productDto
	 * @throws Exception
	 *
	 * @Date 2015年12月25日
	 */
	public void updateProductSales(ProductDto productDto) throws Exception;

}
