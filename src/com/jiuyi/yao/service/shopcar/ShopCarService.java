package com.jiuyi.yao.service.shopcar;

import com.jiuyi.yao.dto.common.ResponseDto;
import com.jiuyi.yao.dto.shopcar.ShopCarDto;

/**
 * @author superb @Date 2015年12月25日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface ShopCarService {
	/**
	 * 
	 * @number 1 @description 用户登录获得购物车数量
	 * 
	 * @param shopCarDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月25日
	 */
	public ResponseDto getCarCount(ShopCarDto shopCarDto) throws Exception;

	/**
	 * 
	 * @number 2 @description 用户未登录查看购物车
	 * 
	 * @param shopCarDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月25日
	 */
	public ResponseDto userCar(ShopCarDto shopCarDto) throws Exception;

	/**
	 * 
	 * @number 3 @description 添加购物车
	 * 
	 * @param shopCarDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月25日
	 */
	public ResponseDto insertShopCar(ShopCarDto shopCarDto) throws Exception;

	/**
	 * 
	 * @number 4 @description 购物车增加商品
	 * 
	 * @param shopCarDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月25日
	 */
	public ResponseDto addCarCount(ShopCarDto shopCarDto) throws Exception;

	/**
	 * 
	 * @number 5 @description 购物车减少商品
	 * 
	 * @param shopCarDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月25日
	 */
	public ResponseDto downCarCount(ShopCarDto shopCarDto) throws Exception;

	/**
	 * 
	 * @number 6 @description 删除购物车
	 * 
	 * @param shopCarDto
	 * @throws Exception
	 *
	 * @Date 2015年12月26日
	 */
	public ResponseDto deleteShopCar(ShopCarDto shopCarDto) throws Exception;

	/**
	 * 
	 * @number 7 @description 手机标识转购物车
	 * 
	 * @param shopCarDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月26日
	 */
	public ResponseDto iemeToUser(ShopCarDto shopCarDto) throws Exception;

	/**
	 * 
	 * @number 8 @description 修改购物车购买状态
	 * 
	 * @param shopCarDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月26日
	 */
	public ResponseDto updateShopCarBuyStatus(ShopCarDto shopCarDto) throws Exception;

}
