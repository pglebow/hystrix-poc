/**
 * 
 */
package com.gap.plan.hystrix.poc.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gap.plan.hystrix.poc.model.DataItem;
import com.gap.plan.hystrix.poc.repository.DataDao;
import com.gap.plan.hystrix.poc.service.DataService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pglebow
 *
 */
@Service
@Slf4j
public class DataServiceImpl implements DataService {

	@Value("${failureFrequency}")
	private Integer failureFrequency;

	private int count;

	@Autowired
	private DataDao dao;

	public DataServiceImpl() {
		this.count = 0;
		log.info("Failure frequency = " + failureFrequency);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gap.plan.hystrix.poc.service.DataService#getData()
	 */
	@Override
	public Set<DataItem> getData() {
		if (++count % failureFrequency == 0) {
			throw new RuntimeException("Fail: Count = " + count);
		}
		return dao.getData();
	}

}
