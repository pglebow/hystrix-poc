/**
 * 
 */
package com.gap.plan.hystrix.poc.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pglebow
 *
 */
@Data
@Builder()
@NoArgsConstructor
@AllArgsConstructor
public class DataItem implements Serializable {

	/**
	 * Serialization
	 */
	private static final long serialVersionUID = 7767486948233703205L;

	private String key;
	
	private String now;
}
