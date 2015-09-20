package com.starboard.b2b.model.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.starboard.b2b.model.BaseModel;

@Entity
@Table(name = "price")
public class Price extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
}
