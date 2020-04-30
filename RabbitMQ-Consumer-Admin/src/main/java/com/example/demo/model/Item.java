package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "@id",scope = Item.class)
@Data
@ToString
@NoArgsConstructor

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
    private String itemName;
    private String category;
    private String description;
	public Item(String itemName, String category, String description) {
		super();
		this.itemName = itemName;
		this.category = category;
		this.description = description;
	}
    
    
}
