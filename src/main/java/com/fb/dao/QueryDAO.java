/**
 *  Copyright (c)  2011-2020 Panguso, Inc.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information of Panguso, 
 *  Inc. ("Confidential Information"). You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into with Panguso.
 */
package com.fb.dao;

import java.util.List;

import com.fb.po.Query;

/**
 * 
 * @author chenmutong
 * @date 2013-2-5
 */
public interface QueryDAO {

	/**
	 * getQuery
	 * 
	 * @return
	 * @author chenmutong
	 * @date 2012-10-9
	 */
	List<Query> getQueryList(String queryWord);

	/**
	 * getQueryById
	 * 
	 * @param id id
	 * @return
	 * @author chenmutong
	 * @date 2012-12-4
	 */
	Query getQueryById(long id);

	/**
	 * @param Query Query
	 * @author chenmutong
	 * @date 2012-12-4
	 */
	void saveQuery(Query Query);

	/**
	 * @param Query Query
	 * @author chenmutong
	 * @date 2012-12-4
	 */
	void updateQueryById(Query Query);

	/**
	 * @param id id
	 * @author chenmutong
	 * @date 2012-12-4
	 */
	void delQueryById(long id);

}
