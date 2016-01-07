package com.jiuyi.yao.servlet;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jiuyi.yao.common.dict.CacheContainer;
import com.jiuyi.yao.common.dict.Constants;
import com.jiuyi.yao.common.util.SysCfg;
import com.jiuyi.yao.service.order.OrderService;

/**
 * @author superb
 * @date 2015年3月26日
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = -5305744701888018846L;

	private final static Logger logger = Logger.getLogger(InitServlet.class);

	@Override
	public void init(ServletConfig config) throws ServletException {
		Constants.applicationContext = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
		CacheContainer.init();
		SysCfg.init();
		expiredOrderHandle();
	}

	/**
	 * @description 过期订单处理
	 */
	private void expiredOrderHandle() {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					Constants.applicationContext.getBean(OrderService.class).expiredOrder();
				} catch (Exception e) {
					logger.info("过期订单处理异常");
				}
			}
		}, 0, 10 * 60 * 1000);
	}

}