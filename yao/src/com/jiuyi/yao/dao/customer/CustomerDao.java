package com.jiuyi.yao.dao.customer;

import java.util.List;

import com.jiuyi.yao.dto.customer.CustomerDto;

/**
 * @author superb @Date 2015年12月12日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface CustomerDao {
	/**
	 * 
	 * @number 1 @description 注册用户
	 * 
	 * @param customerDto
	 * @throws Exception
	 *
	 * @Date 2015年12月12日
	 */
	public void register(CustomerDto customerDto) throws Exception;

	/**
	 * 
	 * @number 2 @description 编辑用户信息
	 * 
	 * @param customerDto
	 * @throws Exception
	 *
	 * @Date 2015年12月12日
	 */
	public void edit(CustomerDto customerDto) throws Exception;

	/**
	 * 
	 * @number 3 @description 修改密码
	 * 
	 * @param customerDto
	 * @throws Exception
	 *
	 * @Date 2015年12月12日
	 */
	public void updatePassword(CustomerDto customerDto) throws Exception;

	/**
	 * 
	 * @number 4 @description 查询用户
	 * 
	 * @param customerDto
	 * @return
	 * @throws Exception
	 *
	 * @Date 2015年12月12日
	 */
	public List<CustomerDto> queryCustomer(CustomerDto customerDto) throws Exception;

	/**
	 * 
	 * @number 5 @description 重置密码
	 * 
	 * @param customerDto
	 * @throws Exception
	 *
	 * @Date 2015年12月12日
	 */
	public void resetPassword(CustomerDto customerDto) throws Exception;
}
