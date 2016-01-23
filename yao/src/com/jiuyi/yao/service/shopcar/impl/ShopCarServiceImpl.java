package com.jiuyi.yao.service.shopcar.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.yao.common.dict.CacheContainer;
import com.jiuyi.yao.common.dict.Constants;
import com.jiuyi.yao.common.util.Enumerate;
import com.jiuyi.yao.common.util.Util;
import com.jiuyi.yao.dao.product.FormatDao;
import com.jiuyi.yao.dao.shopcar.ShopCarDao;
import com.jiuyi.yao.dto.common.ResponseDto;
import com.jiuyi.yao.dto.common.TokenDto;
import com.jiuyi.yao.dto.customer.CustomerDto;
import com.jiuyi.yao.dto.shopcar.ShopCarDto;
import com.jiuyi.yao.service.BusinessException;
import com.jiuyi.yao.service.shopcar.ShopCarService;

/**
 * @author superb @Date 2015年12月25日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
@Service
public class ShopCarServiceImpl implements ShopCarService {
	@Autowired
	private ShopCarDao shopCarDao;

	@Autowired
	private FormatDao formatDao;

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
	@Override
	public ResponseDto getCarCount(ShopCarDto shopCarDto) throws Exception {
		if (shopCarDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		if (!Util.isNotEmpty(shopCarDto.getIeme())) {
			TokenDto tokenDto = CacheContainer.getToken(shopCarDto.getToken());
			CustomerDto cust = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();
			shopCarDto.setUser_id(cust.getUser_id());
		}

		List<ShopCarDto> list = shopCarDao.queryShopCar(shopCarDto);
		System.out.println(list.size());
		Integer totalCount = 0;
		for (int i = 0; i < list.size(); i++) {
			totalCount += list.get(i).getBuy_count();
		}

		ResponseDto responseDto = new ResponseDto();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCount", totalCount);
		responseDto.setDetail(map);
		responseDto.setResultDesc("购物车商品数量");
		return responseDto;
	}

	/**
	 * 
	 * @number 2 @description 查看购物车
	 * 
	 * @param shopCarDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月25日
	 */
	@Override
	public ResponseDto userCar(ShopCarDto shopCarDto) throws Exception {
		if (shopCarDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		if (!Util.isNotEmpty(shopCarDto.getIeme())) {
			TokenDto tokenDto = CacheContainer.getToken(shopCarDto.getToken());
			CustomerDto cust = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();
			shopCarDto.setUser_id(cust.getUser_id());
		}

		List<ShopCarDto> list = shopCarDao.queryShopCar(shopCarDto);
		Integer totalCount = 0;

		for (int i = 0; i < list.size(); i++) {
			// 得到数量
			totalCount += list.get(i).getBuy_count();
			// 计算小计
			list.get(i).setSingleAmount(list.get(i).getProd_price().multiply(new BigDecimal(list.get(i).getBuy_count())));
			// 更新图片链接
			if (Util.isNotEmpty(list.get(i).getImg_src())) {
				list.get(i).setImg_src(Enumerate.IMG_SRC + list.get(i).getImg_src());
			}
		}

		ResponseDto responseDto = new ResponseDto();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", totalCount);
		responseDto.setDetail(map);
		responseDto.setResultDesc("我的购物车");
		return responseDto;
	}

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
	@Override
	public ResponseDto insertShopCar(ShopCarDto shopCarDto) throws Exception {
		if (shopCarDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}
		if (!Util.isNotEmpty(shopCarDto.getProd_id())) {
			throw new BusinessException("请传入商品id");
		}
		if (!Util.isNotEmpty(shopCarDto.getFormat_id())) {
			throw new BusinessException("请选择规格");
		}
		if (shopCarDto.getBuy_count() == null) {
			throw new BusinessException("请选择数量");
		}

		// 用户登录
		if (!Util.isNotEmpty(shopCarDto.getIeme())) {
			TokenDto tokenDto = CacheContainer.getToken(shopCarDto.getToken());
			CustomerDto cust = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();
			shopCarDto.setUser_id(cust.getUser_id());
		}

		System.out.println(shopCarDto.getProd_id() + ";" + shopCarDto.getFormat_id() + shopCarDto.getUser_id());
		List<ShopCarDto> list = shopCarDao.queryShopCar(shopCarDto);
		System.out.println("list size:" + list.size());
		// 如果购物车不存在该商品
		if (list == null || list.isEmpty() || list.size() == 0) {
			shopCarDao.insertShopCar(shopCarDto);
		} else {
			shopCarDao.upShopCar(shopCarDto);
		}

		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultDesc("添加成功");
		return responseDto;
	}

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
	@Override
	public ResponseDto addCarCount(ShopCarDto shopCarDto) throws Exception {
		if (shopCarDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}
		if (!Util.isNotEmpty(shopCarDto.getCar_id())) {
			throw new BusinessException("购物车id不能为空");
		}
		if (shopCarDto.getBuy_count() == null) {
			throw new BusinessException("添加数量不能为空");
		}
		if (!Util.isNotEmpty(shopCarDto.getIeme())) {
			TokenDto tokenDto = CacheContainer.getToken(shopCarDto.getToken());
			CustomerDto cust = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();
			shopCarDto.setUser_id(cust.getUser_id());
		}

		shopCarDao.upShopCar(shopCarDto);

		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultDesc("添加成功");
		return responseDto;
	}

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
	@Override
	public ResponseDto downCarCount(ShopCarDto shopCarDto) throws Exception {
		if (shopCarDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}
		if (!Util.isNotEmpty(shopCarDto.getCar_id())) {
			throw new BusinessException("购物车id不能为空");
		}
		if (shopCarDto.getBuy_count() == null) {
			throw new BusinessException("添加数量不能为空");
		}
		if (!Util.isNotEmpty(shopCarDto.getIeme())) {
			TokenDto tokenDto = CacheContainer.getToken(shopCarDto.getToken());
			CustomerDto cust = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();
			shopCarDto.setUser_id(cust.getUser_id());
		}

		shopCarDao.downShopCar(shopCarDto);

		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultDesc("减少成功");
		return responseDto;
	}

	/**
	 * 
	 * @number 6 @description 删除购物车
	 * 
	 * @param shopCarDto
	 * @throws Exception
	 *
	 * @Date 2015年12月26日
	 */
	@Override
	public ResponseDto deleteShopCar(ShopCarDto shopCarDto) throws Exception {
		if (shopCarDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}
		if (!Util.isNotEmpty(shopCarDto.getIeme())) {
			TokenDto tokenDto = CacheContainer.getToken(shopCarDto.getToken());
			CustomerDto cust = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();
			shopCarDto.setUser_id(cust.getUser_id());
		}

		shopCarDao.deleteShopCarByCarId(shopCarDto);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultDesc("删除成功");
		return responseDto;
	}

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
	@Override
	public ResponseDto iemeToUser(ShopCarDto shopCarDto) throws Exception {
		if (shopCarDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		if (!Util.isNotEmpty(shopCarDto.getIeme())) {
			throw new BusinessException("手机标识码不能为空");
		}

		TokenDto tokenDto = CacheContainer.getToken(shopCarDto.getToken());
		CustomerDto cust = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();
		shopCarDto.setUser_id(cust.getUser_id());

		// 得到手机标识商品
		ShopCarDto shop = new ShopCarDto();
		shop.setIeme(shopCarDto.getIeme());
		List<ShopCarDto> cars = shopCarDao.queryShopCar(shop);
		List<String> carIds = new ArrayList<String>();

		if (cars != null && !cars.isEmpty() && cars.size() > 0) {
			System.out.println("xun huan zhuan rang ");
			for (int i = 0; i < cars.size(); i++) {
				ShopCarDto dto = new ShopCarDto();
				dto = cars.get(i);
				dto.setUser_id(shopCarDto.getUser_id());
				dto.setIeme("");

				List<ShopCarDto> shopcars = new ArrayList<ShopCarDto>();
				shopcars = shopCarDao.queryShopCar(dto);
				if (shopcars != null && !shopcars.isEmpty() && shopcars.size() > 0) {
					shopCarDao.upShopCar(dto);
					carIds.add(dto.getCar_id());
				} else {
					dto.setCar_id(dto.getCar_id());
					dto.setCar_status(1);
					shopCarDao.updateShopCarIemeToUser(dto);
				}

			}
			if (carIds != null && !carIds.isEmpty() && carIds.size() > 0) {
				shopCarDao.deleteShopCarBySomeCarId(carIds);
			}

		}

		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultDesc("数据转让成功");
		return responseDto;
	}

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
	@Override
	public ResponseDto updateShopCarBuyStatus(ShopCarDto shopCarDto) throws Exception {
		if (shopCarDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		if (shopCarDto.getCar_status() == null) {
			throw new BusinessException("请指定购买状态");
		}

		if (!Util.isNotEmpty(shopCarDto.getCar_id())) {
			throw new BusinessException("购物车id不能为空");
		}

		if (!Util.isNotEmpty(shopCarDto.getIeme())) {
			TokenDto tokenDto = CacheContainer.getToken(shopCarDto.getToken());
			CustomerDto cust = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();
			shopCarDto.setUser_id(cust.getUser_id());
		}

		// 修改购物车购买状态0.不买， 1.买
		shopCarDao.updateCarStatus(shopCarDto);
		ResponseDto responseDto = new ResponseDto();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", shopCarDto.getCar_status());
		responseDto.setDetail(map);
		responseDto.setResultDesc("成功");
		return responseDto;
	}
}
