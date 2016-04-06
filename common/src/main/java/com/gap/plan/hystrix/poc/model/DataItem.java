/**
 * 
 */
package com.gap.plan.hystrix.poc.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

/**
 * @author pglebow
 *
 */
@Data
@Builder
public class DataItem implements Serializable {

	/**
	 * Serialization
	 */
	private static final long serialVersionUID = 7767486948233703205L;

	private String key;
	
	private LocalDateTime now;
}
