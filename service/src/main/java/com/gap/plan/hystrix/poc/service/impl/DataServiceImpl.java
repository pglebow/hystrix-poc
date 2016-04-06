/**
 * 
 */
package com.gap.plan.hystrix.poc.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gap.plan.hystrix.poc.model.DataItem;
import com.gap.plan.hystrix.poc.repository.DataDao;
import com.gap.plan.hystrix.poc.service.DataService;

/**
 * @author pglebow
 *
 */
@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private DataDao dao;
	
	/* (non-Javadoc)
	 * @see com.gap.plan.hystrix.poc.service.DataService#getData()
	 */
	@Override
	public Set<DataItem> getData() {
		return dao.getData();
	}

}
