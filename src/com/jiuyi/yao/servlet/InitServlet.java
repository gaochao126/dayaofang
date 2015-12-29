package com.jiuyi.yao.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jiuyi.yao.common.dict.CacheContainer;
import com.jiuyi.yao.common.dict.Constants;
import com.jiuyi.yao.common.util.SysCfg;

/**
 * @author superb
 * @date 2015年3月26日
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = -5305744701888018846L;

	// private final static Logger logger = Logger.getLogger(InitServlet.class);

	@Override
	public void init(ServletConfig config) throws ServletException {
		Constants.applicationContext = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
		CacheContainer.init();
		SysCfg.init();
	}

}