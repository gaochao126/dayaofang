package com.jiuyi.yao.dao.shopcar;

import java.util.List;

import com.jiuyi.yao.dto.shopcar.ShopCarDto;

/**
 * @author superb @Date 2015年12月25日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface ShopCarDao {
	/**
	 * 
	 * @number 1 @description 查询购物车所有商品
	 * 
	 * @param shopCarDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月25日
	 */
	public List<ShopCarDto> queryShopCar(ShopCarDto shopCarDto) throws Exception;

	/**
	 * 
	 * @number 2 @description 添加购物车
	 * 
	 * @param shopCarDto
	 * @throws Exception
	 *
	 * @Date 2015年12月25日
	 */
	public void insertShopCar(ShopCarDto shopCarDto) throws Exception;

	/**
	 * 
	 * @number 3 @description 购物车添加商品（数量增加）
	 * 
	 * @param shopCarDto
	 * @throws Exception
	 *
	 * @Date 2015年12月25日
	 */
	public void upShopCar(ShopCarDto shopCarDto) throws Exception;

	/**
	 * 
	 * @number 4 @description 购物车减少数量
	 * 
	 * @param shopCarDto
	 * @throws Exception
	 *
	 * @Date 2015年12月25日
	 */
	public void downShopCar(ShopCarDto shopCarDto) throws Exception;

	/**
	 * 
	 * @number 5 @description 删除购物车
	 * 
	 * @param shopCarDto
	 * @throws Exception
	 *
	 * @Date 2015年12月25日
	 */
	public void deleteShopCarByCarId(ShopCarDto shopCarDto) throws Exception;

	/**
	 * 
	 * @number 6 @description 批量删除购物车
	 * 
	 * @param carIds
	 * @throws Exception
	 *
	 * @Date 2015年12月25日
	 */
	public void deleteShopCarBySomeCarId(List<String> carIds) throws Exception;

	/**
	 * 
	 * @number 7 @description 将手机标识购物车商品转给用户
	 * 
	 * @param shopCarDto
	 * @throws Exception
	 *
	 * @Date 2015年12月25日
	 */
	public void updateShopCarIemeToUser(ShopCarDto shopCarDto) throws Exception;

	/**
	 * 
	 * @number 8 @description 修改购物车购买状态 0不买，1买
	 * 
	 * @param shopCatDto
	 * @throws Exception
	 *
	 * @Date 2015年12月25日
	 */
	public void updateCarStatus(ShopCarDto shopCarDto) throws Exception;

}
