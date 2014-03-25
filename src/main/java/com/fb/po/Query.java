/**
 *  Copyright (c)  2011-2020 Panguso, Inc.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information of Panguso, 
 *  Inc. ("Confidential Information"). You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into with Panguso.
 */
package com.fb.po;

/**
 * 
 * @author chenmutong
 * @date 2014-3-19
 */
public class Query {

	private Long id;

	private Long productId;

	private String queryWord;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getQueryWord() {
		return queryWord;
	}

	public void setQueryWord(String queryWord) {
		this.queryWord = queryWord;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Query [id=");
		builder.append(id);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", queryWord=");
		builder.append(queryWord);
		builder.append("]");
		return builder.toString();
	}

}
