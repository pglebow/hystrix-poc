/**
 * 
 */
package com.gap.plan.hystrix.poc.controller;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gap.plan.hystrix.poc.model.DataItem;
import com.gap.plan.hystrix.poc.service.DataService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author pglebow
 *
 */
@Controller
@RequestMapping("/api")
public class DataController {

	@Autowired
	private DataService dataService;

	@RequestMapping(value = "data", method = RequestMethod.GET)
	@ResponseBody
	@HystrixCommand(fallbackMethod = "getDefaultData")
	public ResponseEntity<?> getData() {
		ResponseEntity<?> retVal = ResponseEntity.notFound().build();

		retVal = ResponseEntity.ok().body(dataService.getData());

		return retVal;
	}
	
	public ResponseEntity<?> getDefaultData() {
		ResponseEntity<?> retVal = ResponseEntity.notFound().build();
		
		Set<DataItem> s = new HashSet<>();
		DataItem item = DataItem.builder().key("default-data").now(LocalDateTime.now()).build();
		
		s.add(item);
		
		retVal = ResponseEntity.ok().body(s);
		
		return retVal;
	}
}
