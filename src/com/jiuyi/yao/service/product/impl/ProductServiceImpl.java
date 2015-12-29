package com.jiuyi.yao.service.product.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.yao.common.dict.Constants;
import com.jiuyi.yao.common.util.Enumerate;
import com.jiuyi.yao.common.util.Util;
import com.jiuyi.yao.dao.product.ProductDao;
import com.jiuyi.yao.dto.Page;
import com.jiuyi.yao.dto.common.ResponseDto;
import com.jiuyi.yao.dto.product.ProductDto;
import com.jiuyi.yao.service.BusinessException;
import com.jiuyi.yao.service.product.ProductService;

/**
 * @author superb @Date 2015年12月24日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

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
	@Override
	public ResponseDto queryProductList(ProductDto productDto) throws Exception {
		List<ProductDto> products = productDao.queryProductList(productDto);
		for (int i = 0; i < products.size(); i++) {
			if (Util.isNotEmpty(products.get(i).getImg_src())) {
				products.get(i).setImg_src(Enumerate.IMG_SRC + products.get(i).getImg_src());
			}
		}
		ResponseDto responseDto = new ResponseDto();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", products);
		map.put("page", productDto.getPage());
		responseDto.setDetail(map);
		responseDto.setResultDesc("所有商品列表");
		return responseDto;
	}

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
	@Override
	public ResponseDto queryProductBySecond(ProductDto productDto) throws Exception {
		if (productDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}
		if (!Util.isNotEmpty(productDto.getSecond_id())) {
			throw new BusinessException("药品分类Id不能为空");
		}

		List<ProductDto> products = productDao.queryProductListBySecond(productDto);
		for (int i = 0; i < products.size(); i++) {
			if (Util.isNotEmpty(products.get(i).getImg_src())) {
				products.get(i).setImg_src(Enumerate.IMG_SRC + products.get(i).getImg_src());
			}
		}
		ResponseDto responseDto = new ResponseDto();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", products);
		map.put("page", productDto.getPage());
		responseDto.setDetail(map);
		responseDto.setResultDesc("商品列表");
		return responseDto;
	}

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
	@Override
	public ResponseDto queryProductByThird(ProductDto productDto) throws Exception {
		if (productDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}
		if (!Util.isNotEmpty(productDto.getThird_id())) {
			throw new BusinessException("药品分类Id不能为空");
		}

		List<ProductDto> products = productDao.queryProductListByThird(productDto);
		for (int i = 0; i < products.size(); i++) {
			if (Util.isNotEmpty(products.get(i).getImg_src())) {
				products.get(i).setImg_src(Enumerate.IMG_SRC + products.get(i).getImg_src());
			}
		}
		ResponseDto responseDto = new ResponseDto();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", products);
		map.put("page", productDto.getPage());
		responseDto.setDetail(map);
		responseDto.setResultDesc("商品列表");
		return responseDto;
	}

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
	@Override
	public ResponseDto searchProduct(ProductDto productDto) throws Exception {
		if (productDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}
		if (!Util.isNotEmpty(productDto.getProd_name())) {
			throw new BusinessException("请输入搜索的内容");
		}
		List<ProductDto> products = productDao.searchProduct(productDto);
		for (int i = 0; i < products.size(); i++) {
			if (Util.isNotEmpty(products.get(i).getImg_src())) {
				products.get(i).setImg_src(Enumerate.IMG_SRC + products.get(i).getImg_src());
			}
		}
		ResponseDto responseDto = new ResponseDto();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", products);
		map.put("page", productDto.getPage());
		responseDto.setDetail(map);
		responseDto.setResultDesc("搜索商品列表");
		return responseDto;
	}

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
	@Override
	public ResponseDto queryIndexProductList(ProductDto productDto) throws Exception {
		/** 查询广告药品. */
		List<ProductDto> showProd = productDao.queryShowProduct(productDto);
		for (int i = 0; i < showProd.size(); i++) {
			if (Util.isNotEmpty(showProd.get(i).getImg_src())) {
				showProd.get(i).setImg_src(Enumerate.IMG_SRC + showProd.get(i).getImg_src());
			}
		}
		Page page = new Page();
		page.setPageSize(2);
		page.setCurrentPage(1);

		/** 查询养胃药品. */
		ProductDto stom = new ProductDto();
		stom.setPage(page);
		stom.setSecond_id("Ad");
		List<ProductDto> stomachList = productDao.queryProductListBySecond(stom);
		for (int i = 0; i < stomachList.size(); i++) {
			if (Util.isNotEmpty(showProd.get(i).getImg_src())) {
				stomachList.get(i).setImg_src(Enumerate.IMG_SRC + stomachList.get(i).getImg_src());
			}
		}
		/** 查询养肝药品. */
		ProductDto liver = new ProductDto();
		liver.setPage(page);
		liver.setThird_id("At01");
		List<ProductDto> liverList = productDao.queryProductListBySecond(liver);
		for (int i = 0; i < liverList.size(); i++) {
			if (Util.isNotEmpty(showProd.get(i).getImg_src())) {
				liverList.get(i).setImg_src(Enumerate.IMG_SRC + liverList.get(i).getImg_src());
			}
		}
		/** 查询心脑血管药品. */
		ProductDto heart = new ProductDto();
		heart.setPage(page);
		heart.setSecond_id("Ai");
		List<ProductDto> heartList = productDao.queryProductListBySecond(heart);
		for (int i = 0; i < heartList.size(); i++) {
			if (Util.isNotEmpty(showProd.get(i).getImg_src())) {
				heartList.get(i).setImg_src(Enumerate.IMG_SRC + heartList.get(i).getImg_src());
			}
		}
		/** 止咳养肺. */
		ProductDto lung = new ProductDto();
		lung.setPage(page);
		lung.setSecond_id("Ac");
		List<ProductDto> lungList = productDao.queryProductListBySecond(lung);
		for (int i = 0; i < lungList.size(); i++) {
			if (Util.isNotEmpty(showProd.get(i).getImg_src())) {
				lungList.get(i).setImg_src(Enumerate.IMG_SRC + lungList.get(i).getImg_src());
			}
		}

		ResponseDto responseDto = new ResponseDto();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("showProd", showProd);
		map.put("stomachList", stomachList);
		map.put("liverList", liverList);
		map.put("heartList", heartList);
		map.put("lungList", lungList);
		responseDto.setDetail(map);
		responseDto.setResultDesc("首页商品列表");
		return responseDto;
	}
}
