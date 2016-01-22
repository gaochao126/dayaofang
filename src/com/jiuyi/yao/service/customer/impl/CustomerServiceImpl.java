package com.jiuyi.yao.service.customer.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.yao.common.dict.CacheContainer;
import com.jiuyi.yao.common.dict.Constants;
import com.jiuyi.yao.common.util.Enumerate;
import com.jiuyi.yao.common.util.MD5;
import com.jiuyi.yao.common.util.SmsCheckService.CheckResult;
import com.jiuyi.yao.common.util.SmsService;
import com.jiuyi.yao.common.util.Util;
import com.jiuyi.yao.dao.customer.CustomerDao;
import com.jiuyi.yao.dto.common.AccessTokenDto;
import com.jiuyi.yao.dto.common.ResponseDto;
import com.jiuyi.yao.dto.common.TokenDto;
import com.jiuyi.yao.dto.customer.CustomerDto;
import com.jiuyi.yao.dto.sms.SmsRespDto;
import com.jiuyi.yao.service.BusinessException;
import com.jiuyi.yao.service.customer.CustomerService;

/**
 * @author superb @Date 2015年12月12日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	/**
	 * 
	 * @number 1 @description 验证手机号是否存在
	 * 
	 * @param customerDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月12日
	 */
	@Override
	public ResponseDto checkPhoneExit(CustomerDto customerDto) throws Exception {
		if (customerDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}
		if (!Util.isNotEmpty(customerDto.getUser_tel())) {
			throw new BusinessException("手机号码不能为空");
		}
		if (Util.isMobile(customerDto.getUser_tel()) == false) {
			throw new BusinessException("请输入正确手机号");
		}

		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultDesc("查询成功");
		Map<String, Object> map = new HashMap<String, Object>();
		List<CustomerDto> custs = customerDao.queryCustomer(customerDto);
		if (custs != null && !custs.isEmpty() && custs.size() > 0) {
			map.put("isRegister", true);
		} else {
			map.put("isRegister", false);
		}
		responseDto.setDetail(map);
		return responseDto;
	}

	/**
	 * 
	 * @number 2 @description 获取短信验证码
	 * 
	 * @param patientDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月12日
	 */
	@Override
	public ResponseDto getVerifyCode(CustomerDto customerDto) throws Exception {
		/** step1:空异常处理. */
		if (customerDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		/** step2:手机号不为空校验. */
		if (!Util.isNotEmpty(customerDto.getUser_tel())) {
			throw new BusinessException("手机号必须填写");
		}
		if (Util.isMobile(customerDto.getUser_tel()) == false) {
			throw new BusinessException("请输入正确手机号");
		}
		/** step3:发送验证码. */
		SmsRespDto sms = SmsService.instance().sendCode(customerDto.getUser_tel());

		/** step4:返回结果. */
		ResponseDto responseDto = new ResponseDto();

		if (sms.isSuccess()) {
			responseDto.setResultDesc("验证码发送成功");
		} else {
			responseDto.setResultDesc(sms.getReason());
		}

		return responseDto;
	}

	/**
	 * 
	 * @number 3 @description 校验短信验证码
	 * 
	 * @param customerDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月12日
	 */
	@Override
	public ResponseDto checkVerificationCode(CustomerDto customerDto) throws Exception {
		if (customerDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}
		ResponseDto responseDto = new ResponseDto();
		CheckResult sms = SmsService.instance().checkCode(customerDto.getUser_tel(), customerDto.getVerificationCode());
		if (sms.isSuccess()) {
			responseDto.setResultDesc("校验成功");
			String accessToken = MD5.getMD5Code(Util.getUniqueSn());
			AccessTokenDto access = new AccessTokenDto();
			access.setAccessToken(accessToken);
			access.setCurrentTimes(System.currentTimeMillis());
			access.setCachPhone(customerDto.getUser_tel());
			CacheContainer.putAccessToken(accessToken, access);// 存储访问accessToken
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("accessToken", accessToken);
			responseDto.setDetail(dataMap);
		} else {
			responseDto.setResultCode(1);
			responseDto.setResultDesc("校验失败");
		}

		return responseDto;
	}

	/**
	 * 
	 * @number 4 @description 注册
	 * 
	 * @param customerDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月12日
	 */
	@Override
	public ResponseDto register(CustomerDto customerDto) throws Exception {
		/** step1:空异常处理. */
		if (customerDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		/** step2:校验手机号 */
		if (!Util.isNotEmpty(customerDto.getUser_tel())) {
			throw new BusinessException("手机号不能为空");
		}

		/** step3:密码不为空校验. */
		if (!Util.isNotEmpty(customerDto.getUser_password())) {
			throw new BusinessException("密码不能为空");
		}

		if (customerDto.getUser_password().length() != 32) {
			throw new BusinessException("密码加密方式不正确");
		}

		/** step9:验证码校验. */
		if (!Util.isNotEmpty(customerDto.getAccessToken())) {
			throw new BusinessException("无效accessToken");
		}

		AccessTokenDto accessDto = CacheContainer.getAccessToken(customerDto.getAccessToken());
		String value = "";
		if (accessDto != null) {
			value = accessDto.getCachPhone();
		}

		if (!customerDto.getUser_tel().equals(value)) {
			throw new BusinessException("手机未通过验证");
		}

		CacheContainer.removeAccessToken(customerDto.getAccessToken());

		/** step4:注册. */
		CustomerDto cust = new CustomerDto();
		cust.setUser_tel(customerDto.getUser_tel());
		List<CustomerDto> dto = customerDao.queryCustomer(cust);
		if (dto != null && !dto.isEmpty() && dto.size() > 0) {
			throw new BusinessException("手机号码已注册");
		} else {
			// 注册账号
			customerDto.setUser_id(Util.getUniqueSn());
			customerDao.register(customerDto);
		}

		/** step12:存放token信息. */
		String token = MD5.getMD5Code(Util.getUniqueSn());

		customerDto.setToken(token);
		customerDto.setUser_password(null);
		TokenDto tokenDto = new TokenDto();
		tokenDto.setToken(token);
		tokenDto.setCustomerDto(customerDto);
		tokenDto.setUpdateTime(System.currentTimeMillis());
		CacheContainer.saveToken(token, tokenDto);

		/** step13:返回结果. */
		Map<String, String> map = new HashMap<String, String>();
		map.put("token", customerDto.getToken());
		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultDesc("注册成功");
		responseDto.setDetail(map);
		return responseDto;
	}

	/**
	 * 
	 * @number 5 @description 登录
	 * 
	 * @param customerDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月12日
	 */
	@Override
	public ResponseDto signIn(CustomerDto customerDto) throws Exception {
		/** step1:空异常处理. */
		if (customerDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		/** step3:密码不为空校验. */
		if (!Util.isNotEmpty(customerDto.getUser_password())) {
			throw new BusinessException("密码不能为空");
		}

		/** step4:校验账号是否存在. */
		List<CustomerDto> dto = customerDao.queryCustomer(customerDto);
		if (dto == null || dto.isEmpty() || dto.size() == 0) {
			throw new BusinessException("用户不存在");
		}

		/** step5:校验码密码是否正确. */
		if (!customerDto.getUser_password().equals(dto.get(0).getUser_password())) {
			throw new BusinessException("账号或密码错误");
		}

		/** step6:存放token信息. */
		String token = MD5.getMD5Code(Util.getUniqueSn());
		CustomerDto cust = dto.get(0);
		cust.setDeviceType(customerDto.getDeviceType());
		cust.setToken(token);
		TokenDto tokenDto = new TokenDto();
		tokenDto.setToken(token);
		tokenDto.setCustomerDto(cust);
		tokenDto.setUpdateTime(System.currentTimeMillis());
		CacheContainer.saveToken(token, tokenDto);

		/** step8:返回结果. */
		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultDesc("登录成功");
		responseDto.setDetail(dto);
		return responseDto;
	}

	/**
	 * 
	 * @number 6 @description 编辑个人信息
	 * 
	 * @param customerDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月12日
	 */
	@Override
	public ResponseDto edit(CustomerDto customerDto) throws Exception {
		if (customerDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		TokenDto tokenDto = CacheContainer.getToken(customerDto.getToken());
		CustomerDto cust = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();

		customerDto.setUser_id(cust.getUser_id());

		customerDao.edit(customerDto);

		/** step4:更新token. */
		TokenDto token = new TokenDto();
		CustomerDto custId = new CustomerDto();
		custId.setUser_id(cust.getUser_id());
		List<CustomerDto> customers = customerDao.queryCustomer(custId);
		CustomerDto dto = customers.get(0);

		dto.setToken(customerDto.getToken());
		dto.setUser_password(null);
		token.setCustomerDto(dto);
		tokenDto.setToken(customerDto.getToken());
		tokenDto.setUpdateTime(System.currentTimeMillis());
		CacheContainer.saveToken(customerDto.getToken(), token);

		/** step5:返回结果. */
		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultDesc("修改个人信息成功");
		responseDto.setDetail(dto);
		return responseDto;
	}

	/**
	 * 
	 * @number 7 @description 修改密码
	 * 
	 * @param customerDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月12日
	 */
	@Override
	public ResponseDto modifyPassword(CustomerDto customerDto) throws Exception {
		/** step1:空异常处理. */
		if (customerDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		/** step2:校验用户ID. */
		if (!Util.isNotEmpty(customerDto.getUser_id())) {
			throw new BusinessException("用户ID不能为空");
		}

		/** step3:旧密码空校验. */
		if (!Util.isNotEmpty(customerDto.getOldPassword())) {
			throw new BusinessException("旧密码不能为空");
		}

		/** step4:新密码空校验. */
		if (!Util.isNotEmpty(customerDto.getNewPassword())) {
			throw new BusinessException("新密码不能为空");
		}

		/** step5:校验是否为本人操作. */
		TokenDto token = CacheContainer.getToken(customerDto.getToken());
		if (customerDto.getUser_id() == null || (token != null && token.getCustomerDto() != null && !customerDto.getUser_id().equals(token.getCustomerDto().getUser_id()))) {
			throw new BusinessException("非本人操作");
		}

		/** step6:校验账号是否正确. */
		CustomerDto custId = new CustomerDto();
		custId.setUser_id(customerDto.getUser_id());
		List<CustomerDto> dto = customerDao.queryCustomer(custId);
		if (dto == null || dto.isEmpty() || dto.size() == 0) {
			throw new BusinessException("账号不存在");
		}

		/** step7:旧密码正确性校验. */
		if (!customerDto.getOldPassword().equals(dto.get(0).getUser_password())) {
			throw new BusinessException("旧密码不对");
		}

		/** step8:更新数据库. */
		customerDto.setUser_password(customerDto.getNewPassword());
		customerDao.updatePassword(customerDto);

		/** step9:返回结果. */
		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultDesc("修改密码成功");
		return responseDto;
	}

	/**
	 * 
	 * @number 8 @description 重置密码
	 * 
	 * @param patientDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月12日
	 */
	@Override
	public ResponseDto resetPassword(CustomerDto customerDto) throws Exception {
		/** step1:空异常处理. */
		if (customerDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		/** step2:账号空校验. */
		if (!Util.isNotEmpty(customerDto.getUser_tel())) {
			throw new BusinessException("手机号不能为空");
		}

		/** step3:新密码空校验. */
		if (!Util.isNotEmpty(customerDto.getNewPassword())) {
			throw new BusinessException("新密码不能为空");
		}

		/** step4:验证码校验. */
		if (!Util.isNotEmpty(customerDto.getAccessToken())) {
			throw new BusinessException("无效accessToken");
		}

		AccessTokenDto accessDto = CacheContainer.getAccessToken(customerDto.getAccessToken());
		String value = "";
		if (accessDto != null) {
			value = accessDto.getCachPhone();
		}

		if (!customerDto.getUser_tel().equals(value)) {
			throw new BusinessException("手机未通过验证");
		}

		CacheContainer.removeAccessToken(customerDto.getAccessToken());

		/** step5:校验账号是否存在. */
		CustomerDto cust = new CustomerDto();
		cust.setUser_tel(customerDto.getUser_tel());
		List<CustomerDto> dto = customerDao.queryCustomer(cust);
		if (dto == null) {
			throw new BusinessException("账号不存在");
		}

		/** step6:更新数据库. */
		cust.setUser_password(customerDto.getNewPassword());
		customerDao.resetPassword(cust);

		/** step8:返回结果. */
		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultDesc("重置密码成功");
		return responseDto;
	}

	/**
	 * 
	 * @number 9 @description 查询用户详情
	 * 
	 * @param customerDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月12日
	 */
	@Override
	public ResponseDto customerInfo(CustomerDto customerDto) throws Exception {
		if (customerDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		TokenDto tokenDto = CacheContainer.getToken(customerDto.getToken());
		CustomerDto cust = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();

		ResponseDto responseDto = new ResponseDto();
		responseDto.setDetail(cust);
		responseDto.setResultDesc("用户信息");
		return responseDto;
	}

	/**
	 * 
	 * @number 10 @description 获取注册协议
	 * 
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月12日
	 */
	@Override
	public ResponseDto getAgreement(CustomerDto customerDto) throws Exception {
		String src = Enumerate.REGISTER_SRC;
		ResponseDto responseDto = new ResponseDto();
		responseDto.setDetail(src);
		responseDto.setResultDesc("注册协议");
		return responseDto;
	}

	/**
	 * 
	 * @number 11 @description 修改手机号
	 * 
	 * @param patientDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月12日
	 */
	@Override
	public ResponseDto resetPhone(CustomerDto customerDto) throws Exception {
		/** step1:空异常处理. */
		if (customerDto == null) {
			throw new BusinessException(Constants.DATA_ERROR);
		}

		TokenDto tokenDto = CacheContainer.getToken(customerDto.getToken());
		CustomerDto customer = tokenDto != null ? tokenDto.getCustomerDto() : new CustomerDto();

		/** step2:校验用户ID. */
		if (!Util.isNotEmpty(customerDto.getUser_id())) {
			throw new BusinessException("用户ID不能为空");
		}

		/** step3:旧密码空校验. */
		if (!Util.isNotEmpty(customerDto.getNewPhone())) {
			throw new BusinessException("请输入新手机号");
		}

		/** step5:校验是否为本人操作. */
		TokenDto token = CacheContainer.getToken(customerDto.getToken());
		if (customerDto.getUser_id() == null || (token != null && token.getCustomerDto() != null && !customerDto.getUser_id().equals(token.getCustomerDto().getUser_id()))) {
			throw new BusinessException("非本人操作");
		}

		/** step4:验证码校验. */
		if (!Util.isNotEmpty(customerDto.getAccessToken())) {
			throw new BusinessException("无效accessToken");
		}

		AccessTokenDto accessDto = CacheContainer.getAccessToken(customerDto.getAccessToken());
		String value = "";
		if (accessDto != null) {
			value = accessDto.getCachPhone();
		}

		if (!customerDto.getNewPhone().equals(value)) {
			throw new BusinessException("手机未通过验证");
		}

		CacheContainer.removeAccessToken(customerDto.getAccessToken());

		/** step5:校验账号是否存在. */
		CustomerDto cust = new CustomerDto();
		cust.setUser_id(customerDto.getUser_id());
		List<CustomerDto> dto = customerDao.queryCustomer(cust);
		if (dto == null || dto.isEmpty() || dto.size() == 0) {
			throw new BusinessException("账号不存在");
		}

		/** step6:更新数据库. */
		cust.setUser_tel(customerDto.getNewPhone());
		cust.setUser_id(customer.getUser_id());
		customerDao.edit(customerDto);

		/** step8:返回结果. */
		ResponseDto responseDto = new ResponseDto();
		responseDto.setResultDesc("手机号修改成功");
		return responseDto;
	}
}
