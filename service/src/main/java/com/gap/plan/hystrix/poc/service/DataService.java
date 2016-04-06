/**
 * 
 */
package com.gap.plan.hystrix.poc.service;

import java.util.Set;

import com.gap.plan.hystrix.poc.model.DataItem;

/**
 * @author pglebow
 *
 */
public interface DataService {

	/**
	 * Dummy data
	 * 
	 * @return
	 */
	Set<DataItem> getData();

}
