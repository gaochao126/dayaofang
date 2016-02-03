package com.jiuyi.yao.action.product;

import org.springframework.beans.factory.annotation.Autowired;

import com.jiuyi.yao.action.BaseAction;
import com.jiuyi.yao.common.dict.Constants;
import com.jiuyi.yao.dto.common.ResponseDto;
import com.jiuyi.yao.dto.product.ProductDto;
import com.jiuyi.yao.service.product.ProductService;

/**
 * @author superb    @Date 2016年2月3日
 * 
 * @Description 
 *
 * @Copyright 2016 重庆柒玖壹健康管理有限公司
 */
public class ProductAction extends BaseAction {

	private static final long serialVersionUID = 7782121447429596283L;

	@Autowired
	private ProductService productService;

	private ProductDto productDto;

	private ResponseDto responseDto;

	/**
	 * 2、通过ID去详情 单页
	 */
	public String toInformation() {
		System.out.println(productDto.getProd_id());
		System.out.println("___________");
		try {
			this.setDataObj(productService.prodInfo(productDto));
		} catch (Exception e) {
			ResponseDto responseDto = new ResponseDto();
			responseDto.setResultCode(1);
			responseDto.setResultDesc(e.getMessage());
			print(Constants.gson.toJson(responseDto));
		}
		return "toinforOk";
	}

	public ResponseDto getResponseDto() {
		return responseDto;
	}

	public void setResponseDto(ResponseDto responseDto) {
		this.responseDto = responseDto;
	}

	public ProductDto getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

}
