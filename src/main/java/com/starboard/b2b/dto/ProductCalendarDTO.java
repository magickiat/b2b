
package com.starboard.b2b.dto;

import java.util.Date;

public class ProductCalendarDTO {

	private int idCalendar;
	private String descriptions;
	private Date dateEvent;

	public int getIdCalendar() {
		return idCalendar;
	}

	public void setIdCalendar(int idCalendar) {
		this.idCalendar = idCalendar;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public Date getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}

}
