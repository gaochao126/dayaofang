package com.jiuyi.yao.service.syscfg.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.yao.dao.syscfg.SysCfgDao;
import com.jiuyi.yao.dto.syscfg.SysCfgDto;
import com.jiuyi.yao.service.syscfg.SysCfgService;

/**
 * @author superb @Date 2015年12月12日
 * 
 * @Description
 *
 * @Copyright 2015 重庆柒玖壹健康管理有限公司
 */
@Service
public class SysCfgServiceImpl implements SysCfgService {
	@Autowired
	private SysCfgDao sysCfgDao;

	/**
	 * @description 获取所有系统配置
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<SysCfgDto> getAllSysCfg() throws Exception {
		return sysCfgDao.getAllSysCfg();
	}
}
