package com.jiuyi.yao.common.dict;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.jiuyi.yao.dto.common.AccessTokenDto;
import com.jiuyi.yao.dto.common.TokenDto;
import com.jiuyi.yao.dto.customer.CustomerDto;
import com.jiuyi.yao.service.area.AreaService;
import com.jiuyi.yao.service.customer.CustomerService;
import com.jiuyi.yao.service.kind.KindService;
import com.jiuyi.yao.service.product.ProductService;
import com.jiuyi.yao.service.shopcar.ShopCarService;

public class CacheContainer {
	private final static Logger logger = Logger.getLogger(CacheContainer.class);

	/** 业务map. */
	public static Map<String, Class<?>> serviceMap;

	/** token map. */
	private static Map<String, TokenDto> tokenMap;

	/** 注册访问token. */
	private static Map<String, AccessTokenDto> accessToken;

	/** not authentication map. */
	public static Map<String, Object> notAuthMap;

	public static void init() {
		logger.info("init初始化---");
		serviceMap = new HashMap<String, Class<?>>();
		tokenMap = new ConcurrentHashMap<String, TokenDto>();
		notAuthMap = new HashMap<String, Object>();
		accessToken = new ConcurrentHashMap<String, AccessTokenDto>();

		/** service interface. */
		serviceMap.put("checkPhoneExit", CustomerService.class);
		serviceMap.put("getVerifyCode", CustomerService.class);
		serviceMap.put("checkVerificationCode", CustomerService.class);
		serviceMap.put("register", CustomerService.class);
		serviceMap.put("signIn", CustomerService.class);
		serviceMap.put("edit", CustomerService.class);
		serviceMap.put("modifyPassword", CustomerService.class);
		serviceMap.put("resetPassword", CustomerService.class);
		serviceMap.put("customerInfo", CustomerService.class);
		serviceMap.put("getAgreement", CustomerService.class);
		serviceMap.put("resetPhone", CustomerService.class);
		serviceMap.put("queryProductList", ProductService.class);
		serviceMap.put("queryProductBySecond", ProductService.class);
		serviceMap.put("queryProductByThird", ProductService.class);
		serviceMap.put("searchProduct", ProductService.class);
		serviceMap.put("queryIndexProductList", ProductService.class);
		serviceMap.put("queryType", KindService.class);
		serviceMap.put("querySecondByTypeId", KindService.class);
		serviceMap.put("queryThirdBySecondId", KindService.class);
		serviceMap.put("queryProvinceCascade", AreaService.class);
		serviceMap.put("queryCityByProvinceCascade", AreaService.class);
		serviceMap.put("queryTownByCityCascade", AreaService.class);
		serviceMap.put("getCarCount", ShopCarService.class);
		serviceMap.put("userCar", ShopCarService.class);
		serviceMap.put("insertShopCar", ShopCarService.class);
		serviceMap.put("addCarCount", ShopCarService.class);
		serviceMap.put("downCarCount", ShopCarService.class);
		serviceMap.put("deleteShopCar", ShopCarService.class);
		serviceMap.put("iemeToUser", ShopCarService.class);
		serviceMap.put("updateShopCarBuyStatus", ShopCarService.class);
		serviceMap.put("addAddress", AreaService.class);
		serviceMap.put("updateAddress", AreaService.class);
		serviceMap.put("queryAddress", AreaService.class);
		serviceMap.put("deleteAddress", AreaService.class);

		/** notAuthMap. */
		notAuthMap.put("checkPhoneExit", null);
		notAuthMap.put("getVerifyCode", null);
		notAuthMap.put("checkVerificationCode", null);
		notAuthMap.put("register", null);
		notAuthMap.put("signIn", null);
		notAuthMap.put("resetPassword", null);
		notAuthMap.put("getAgreement", null);
		notAuthMap.put("queryProductList", null);
		notAuthMap.put("queryProductBySecond", null);
		notAuthMap.put("queryProductByThird", null);
		notAuthMap.put("searchProduct", null);
		notAuthMap.put("queryIndexProductList", null);
		notAuthMap.put("queryType", null);
		notAuthMap.put("querySecondByTypeId", null);
		notAuthMap.put("queryThirdBySecondId", null);
		notAuthMap.put("queryProvinceCascade", null);
		notAuthMap.put("queryCityByProvinceCascade", null);
		notAuthMap.put("queryTownByCityCascade", null);
		notAuthMap.put("getCarCount", null);
		notAuthMap.put("userCar", null);
		notAuthMap.put("insertShopCar", null);
		notAuthMap.put("addCarCount", null);
		notAuthMap.put("downCarCount", null);
		notAuthMap.put("deleteShopCar", null);
		notAuthMap.put("iemeToUser", null);
		notAuthMap.put("updateShopCarBuyStatus", null);

		/** update token map . */
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				for (String key : tokenMap.keySet()) {
					TokenDto token = tokenMap.get(key);
					if (token == null) {
						continue;
					}
					if (System.currentTimeMillis() - token.getUpdateTime() > 24 * 60 * 60 * 1000) {
						tokenMap.remove(key);
					}
				}

				for (String k : accessToken.keySet()) {
					AccessTokenDto access = accessToken.get(k);
					if (access == null) {
						continue;
					}
					if (System.currentTimeMillis() - access.getCurrentTimes() > 5 * 60 * 1000) {
						accessToken.remove(k);
					}
				}
			}
		}, 0, 60 * 1000);
	}

	/**
	 * @description 获取token
	 * @param key
	 * @return
	 */
	public static TokenDto getToken(String key) {
		return tokenMap.get(key);
	}

	/**
	 * @description 删除token
	 * @param key
	 */
	public static void removeToken(String key) {
		if (tokenMap.containsKey(key)) {
			tokenMap.remove(key);
		}
	}

	/**
	 * @description 删除token
	 * @param key
	 */
	public static void saveToken(String key, TokenDto tokenDto) {
		tokenDto.getCustomerDto().setUser_password(null);
		tokenMap.put(key, tokenDto);
	}

	/**
	 * @description 根据患者更新token
	 * @param patient
	 */
	public static void updateTokenByCustomer(CustomerDto customer) {
		for (String key : tokenMap.keySet()) {
			TokenDto token = tokenMap.get(key);
			if (token != null) {
				CustomerDto dto = token.getCustomerDto();
				if (dto != null && dto.getUser_id() != null && dto.getUser_id().equals(customer.getUser_id())) {
					token.setCustomerDto(customer);
					customer.setUser_password(null);
				}
			}
		}
	}

	/**
	 * @description 获取token
	 * @param key
	 * @return
	 */
	public static AccessTokenDto getAccessToken(String key) {
		return accessToken.get(key);
	}

	/**
	 * @description 删除token
	 * @param key
	 */
	public static void removeAccessToken(String key) {
		if (accessToken.containsKey(key)) {
			accessToken.remove(key);
		}
	}

	/**
	 * @description 添加token
	 * @param key
	 * @param value
	 */
	public static void putAccessToken(String key, AccessTokenDto accessTokenDto) {
		accessToken.put(key, accessTokenDto);
	}

}