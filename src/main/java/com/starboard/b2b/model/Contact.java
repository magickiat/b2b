package com.starboard.b2b.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

}
