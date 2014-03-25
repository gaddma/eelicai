/**
 *  Copyright (c)  2011-2020 Panguso, Inc.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information of Panguso, 
 *  Inc. ("Confidential Information"). You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into with Panguso.
 */
package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.dao.QueryDAO;
import com.fb.po.Query;
import com.fb.service.QueryService;

/**
 * 
 * @author chenmutong
 * @date 2013-2-5
 */
@Service
public class QueryServiceImpl implements QueryService {

	@Autowired
	private QueryDAO QueryDAO;

	/**
	 * getQuery
	 * 
	 * @return
	 * @author chenmutong
	 * @date 2012-10-9
	 */
	public List<Query> getQueryList(String queryWord) {
		return QueryDAO.getQueryList(queryWord);
	}

	/**
	 * getQueryById
	 * 
	 * @param id id
	 * @return
	 * @author chenmutong
	 * @date 2012-12-4
	 */
	public Query getQueryById(long id) {
		return QueryDAO.getQueryById(id);
	}

	/**
	 * @param Query Query
	 * @author chenmutong
	 * @date 2012-12-4
	 */
	public void saveQuery(Query Query) {
		QueryDAO.saveQuery(Query);
	}

	/**
	 * @param Query Query
	 * @author chenmutong
	 * @date 2012-12-4
	 */
	public void updateQueryById(Query Query) {
		QueryDAO.updateQueryById(Query);
	}

	/**
	 * @param id id
	 * @author chenmutong
	 * @date 2012-12-4
	 */
	public void delQueryById(long id) {
		QueryDAO.delQueryById(id);
	}

}
