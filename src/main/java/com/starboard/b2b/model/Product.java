package com.starboard.b2b.model;

import javax.persistence.Entity;

@Entity
public class Product extends BaseModel {
	private String code;
	private String name;
	private double price;
	
	
	private Brand brand;
}
