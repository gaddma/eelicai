/**
 *  Copyright (c)  2011-2020 Panguso, Inc.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information of Panguso, 
 *  Inc. ("Confidential Information"). You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into with Panguso.
 */
package com.fb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.fb.dao.QueryDAO;
import com.fb.po.Query;

/**
 * 
 * @author chenmutong
 * @date 2013-1-24
 */
@Service
public class QueryDAOImpl implements QueryDAO {

	@Resource
	private SqlSessionTemplate sqlSession;

	@Override
	public List<Query> getQueryList(String queryWord) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("queryWord", queryWord);
			List<Query> landing = sqlSession.selectList("QuerySQL.getQueryList_sql", map);
			return landing;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Query getQueryById(long id) {
		try {
			Query result = sqlSession.selectOne("QuerySQL.getQueryById_sql", id);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void saveQuery(Query Query) {
		try {
			sqlSession.insert("QuerySQL.saveQuery_sql", Query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateQueryById(Query Query) {
		try {
			sqlSession.update("QuerySQL.updateQueryById_sql", Query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delQueryById(long id) {
		try {
			sqlSession.delete("QuerySQL.delQueryById_sql", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
