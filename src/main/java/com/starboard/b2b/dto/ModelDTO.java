package com.starboard.b2b.dto;

import com.starboard.b2b.model.product.Model;

public class ModelDTO {
	private String id;
	private String name;

	public ModelDTO() {
	}

	public ModelDTO(Model model) {
		this.id = model.getId();
		this.name = model.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
