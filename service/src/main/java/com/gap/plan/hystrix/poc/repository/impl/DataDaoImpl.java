/**
 * 
 */
package com.gap.plan.hystrix.poc.repository.impl;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.gap.plan.hystrix.poc.model.DataItem;
import com.gap.plan.hystrix.poc.repository.DataDao;

/**
 * @author pglebow
 *
 */
@Repository
public class DataDaoImpl implements DataDao {

	/* (non-Javadoc)
	 * @see com.gap.plan.hystrix.poc.repository.DataDao#getData()
	 */
	@Override
	public Set<DataItem> getData() {
		Set<DataItem> retVal = new HashSet<>();
		
		DataItem i0 = DataItem.builder().key("t0").now(LocalDateTime.now()).build();
		DataItem i1 = DataItem.builder().key("t1").now(LocalDateTime.now()).build();
		
		retVal.add(i0);
		retVal.add(i1);
		
		return retVal;
	}

}
