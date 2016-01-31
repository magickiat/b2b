package com.starboard.b2b.dto;

import java.util.List;

/**
 * Created by User: Thanakit Jumparuang (jthanakit.dev@gmail.com) Date: 1/26/2016 00:26
 */
public class EventCalendarDTO {
    private List<Event> events;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public static class Event {
        private long date;
        private String type;
        private String title;
        private String description;
        private String url;

        public long getDate() {
            return date;
        }

        public void setDate(long date) {
            this.date = date;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
