package com.jiuyi.yao.service.customer;

import com.jiuyi.yao.dto.common.ResponseDto;
import com.jiuyi.yao.dto.customer.CustomerDto;

/**
 * @author superb @Date 2015年12月12日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface CustomerService {
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
	public ResponseDto checkPhoneExit(CustomerDto customerDto) throws Exception;

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
	public ResponseDto getVerifyCode(CustomerDto customerDto) throws Exception;

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
	public ResponseDto checkVerificationCode(CustomerDto customerDto) throws Exception;

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
	public ResponseDto register(CustomerDto customerDto) throws Exception;

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
	public ResponseDto signIn(CustomerDto customerDto) throws Exception;

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
	public ResponseDto edit(CustomerDto customerDto) throws Exception;

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
	public ResponseDto modifyPassword(CustomerDto customerDto) throws Exception;

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
	public ResponseDto resetPassword(CustomerDto customerDto) throws Exception;

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
	public ResponseDto customerInfo(CustomerDto customerDto) throws Exception;

	/**
	 * 
	 * @number 10 @description 获取注册协议
	 * 
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月12日
	 */
	public ResponseDto getAgreement(CustomerDto customerDto) throws Exception;

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
	public ResponseDto resetPhone(CustomerDto customerDto) throws Exception;
}
