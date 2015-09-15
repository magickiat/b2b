package com.starboard.b2b.model.product;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.starboard.b2b.model.BaseModel;

@Entity
@Table(name = "image")
public class Image extends BaseModel {
	private String big;
	private String medium;
	private String small;
	
	public Image() {
	}
	
	public String getBig() {
		return big;
	}
	public void setBig(String big) {
		this.big = big;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public String getSmall() {
		return small;
	}
	public void setSmall(String small) {
		this.small = small;
	}
}
