/**
 *  Copyright (c)  2011-2020 Panguso, Inc.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information of Panguso, 
 *  Inc. ("Confidential Information"). You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into with Panguso.
 */
package com.fb.listener;

import java.io.File;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;

import com.fb.Constant;
import com.fb.utils.LogConfig;
import com.fb.utils.PropertyUtil;

/**
 * 
 * @author chenmutong
 * @date 2013-6-19
 */
public class SystemInitListener extends ContextLoaderListener {
	private static final Logger logger = LoggerFactory
			.getLogger(SystemInitListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			String path = sce.getServletContext().getRealPath("/") + "WEB-INF"
					+ File.separator + "conf";

			Constant.resourcePath = sce.getServletContext().getRealPath("/")
					+ "resources" + File.separator;

			// init log system
			LogConfig.config(path + File.separator + "logback.xml");

			PropertyUtil
					.initialize(path + File.separator + "common.properties");

			String serverUrl = PropertyUtil.getValue(Constant.SERVER_URL);
			String resource = PropertyUtil.getValue(Constant.RESOURCE);
			sce.getServletContext().setAttribute("serverUrl", serverUrl);
			sce.getServletContext().setAttribute("resource", resource);
			
			logger.info("--------------system init finish-----------------");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
	}

}