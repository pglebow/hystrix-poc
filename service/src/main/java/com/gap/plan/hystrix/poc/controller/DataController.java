/**
 * 
 */
package com.gap.plan.hystrix.poc.controller;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.gap.plan.hystrix.poc.model.DataItem;
import com.gap.plan.hystrix.poc.service.DataService;

/**
 * @author pglebow
 *
 */
@Controller
public class DataController {

	@Autowired
	private DataService dataService;
		
	public Set<DataItem> getData() {
		Set<DataItem> retVal = null;

		retVal = dataService.getData();
		
		return Optional.ofNullable(retVal).orElse(Collections.emptySet());
	}

	public ResponseEntity<?> getDefaultData() {
		ResponseEntity<?> retVal = ResponseEntity.notFound().build();

		Set<DataItem> s = new HashSet<>();
		DataItem item = DataItem.builder().key("default-data").now(LocalDateTime.now().toString()).build();

		s.add(item);

		retVal = ResponseEntity.ok().body(s);

		return retVal;
	}
}
