package com.starboard.b2b.web.form.feed;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Ken on 10/1/2015.
 */
public class CreateFeedContentForm {

    private int id;
    private int page;
    @NotBlank(message = "Title is required.")
    private String title;

    @NotBlank(message = "Content is required.")
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
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
