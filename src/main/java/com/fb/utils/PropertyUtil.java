/**
 *  Copyright (c)  2011-2020 Panguso, Inc.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information of Panguso, 
 *  Inc. ("Confidential Information"). You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into with Panguso.
 */
package com.fb.utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author chenmutong
 * @date 2011-10-20
 */
public final class PropertyUtil {
	private static Properties properties;
	private static final Logger log = LoggerFactory
			.getLogger(PropertyUtil.class);
	private String path;
	private static final PropertyUtil instance = new PropertyUtil();

	private PropertyUtil() {
	}

	public static PropertyUtil getInstance() {
		return instance;
	}

	/**
	 * 
	 * @author piaohailin
	 * @throws Exception
	 * @date 2012-11-26
	 */
	public void initialize() throws Exception {
		if (path == null) {
			throw new Exception("property file is not found.");
		}
		// String tmp = path.replace("/", File.separator);
		String classpath = PropertyUtil.class.getResource("/").getPath();
		String webpath = classpath.substring(0, classpath.length()
				- "WEB-INF/classes/".length());
		if (path.startsWith("/WEB-INF")) {
			properties = init(webpath + path.substring(1));
		} else if (path.startsWith("WEB-INF")) {
			properties = init(webpath + path);
		} else if (path.startsWith("classpath:/")) {
			properties = init(classpath
					+ path.substring("classpath:/".length()));
		} else if (path.startsWith("classpath:")) {
			properties = init(classpath + path.substring("classpath:".length()));
		} else {
			properties = init(path);
		}
	}

	public static void initialize(String propFile) {
		properties = init(propFile);
	}

	public static String getValue(String key) {
		return properties.get(key).toString();
	}

	private static Properties init(String propFile) {
		Properties props;
		try {
			props = new Properties();
			props.load(new FileInputStream(propFile));
			log.info(propFile + " loaded");
			return props;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return this.path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

}