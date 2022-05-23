package com.sample.nace.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@Entity
@Table(name = "nace")
@Data
@NoArgsConstructor
public class Nace {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    private String orderNumber;
	
	private int level;
	
	private String code;
	
	private String parent;
	
	private String description;
	
	private String includedItems;
	
	private String includedItemsExtn;
	
	private String ruling;
	
	private String excludedItems;
	
	private String reference;


}
