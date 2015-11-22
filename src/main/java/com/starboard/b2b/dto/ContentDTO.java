package com.starboard.b2b.dto;

import com.starboard.b2b.model.Content;
import com.starboard.b2b.model.Customer;

/**
 * Created by Ken on 9/29/2015.
 */
public class ContentDTO extends BaseDTO {

    private Integer id;
    private String title;
    private String content;

    public ContentDTO(){}
    
	public ContentDTO(Content cont) {
		super(cont);
		this.id = cont.getId();
		this.title = cont.getTitle();
		this.content = cont.getContent();
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


}
