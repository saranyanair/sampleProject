/**
 * 
 */
package com.sample.nace.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ccuk
 *
 */
@Getter
@Setter
@ToString
public class NaceDataModel {
	
	private String orderNumber;
	
	private int level;
	
	private String code;
	
	private String parent;
	
	private String description;
	
	private String includedItems;
	
	private String includedItemsExtn;
	
	private String ruling;
	
	private String excludedItems;
	
	private String referance;

}
