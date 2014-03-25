package com.fb.test;


import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fb.po.Query;
import com.fb.service.QueryService;

public class QueryTest {
	private static QueryService dataRateService;
	private static Query query;

	@BeforeClass
	public static void before() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
		        new String[] {"classpath:root-context.xml" });
		dataRateService = (QueryService) context.getBean("queryServiceImpl");
		query = new Query();
		query.setProductId(-1l);
		query.setQueryWord("测试中");

	}

	@Test
	public void addQuery() {
		dataRateService.saveQuery(query);
	}
	
	@Test
	public void getQueryById() {
		Query p = dataRateService.getQueryById(query.getId());
		Assert.assertEquals(p.getQueryWord(), query.getQueryWord());
	}

	@Test
	public void getQueryList() {
		List<Query> queryList = dataRateService.getQueryList("测试");
		Assert.assertEquals(queryList.size() > 0, true);
	}

	@Test
	public void updateQuery() {
		query.setQueryWord("测试完");
		dataRateService.updateQueryById(query);
		Query p = dataRateService.getQueryById(query.getId());
		Assert.assertEquals(p.getQueryWord(), query.getQueryWord());
	}

	@Test
	public void deleteQuery() {
		dataRateService.delQueryById(query.getId());
		Query p = dataRateService.getQueryById(query.getId());
		Assert.assertNull(p);
	}
}
