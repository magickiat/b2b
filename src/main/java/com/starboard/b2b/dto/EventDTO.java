package com.starboard.b2b.dto;

import com.starboard.b2b.model.Event;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *
 * Created by User: Thanakit Jumparuang (jthanakit.dev@gmail.com) Date: 1/22/2016 16:47
 */
public class EventDTO extends BaseDTO {

    private Integer id;
    private String title;
    private String content;
    private String fullContent;
    @DateTimeFormat(pattern = "YYYY-MM-DD HH:mm")
    private Date timeEvent;
    private boolean isMore;

    public EventDTO(){}

	public EventDTO(Event event) {
		super(event);
		this.id = event.getId();
		this.title = event.getTitle();
		this.content = event.getContent();
	}
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    public boolean getIsMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }

    public Date getTimeEvent() {
        return timeEvent;
    }

    public void setTimeEvent(Date timeEvent) {
        this.timeEvent = timeEvent;
    }
}
