/**
 * 
 */
package com.gap.plan.hystrix.poc.repository;

import java.util.Set;

import com.gap.plan.hystrix.poc.model.DataItem;

/**
 * @author pglebow
 *
 */
public interface DataDao {

	/**
	 * Dummy data
	 * @return
	 */
	Set<DataItem> getData();
}
