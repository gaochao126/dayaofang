package com.jiuyi.yao.dao.syscfg;

import java.util.List;

import com.jiuyi.yao.dto.syscfg.SysCfgDto;

/**
 * @author superb @Date 2015年12月12日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
public interface SysCfgDao {
	/**
	 * @description 获取所有系统配置
	 * @return
	 * @throws Exception
	 */
	public List<SysCfgDto> getAllSysCfg() throws Exception;
}
