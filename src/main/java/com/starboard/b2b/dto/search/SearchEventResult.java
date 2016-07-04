package com.starboard.b2b.dto.search;

import com.starboard.b2b.model.Event;

import java.util.List;

/**
 * Created by User: Thanakit Jumparuang (jthanakit.dev@gmail.com) Date: 1/21/2016 13:02
 */
public class SearchEventResult {
    private long total;

    private List<Event> result;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Event> getResult() {
        return result;
    }

    public void setResult(List<Event> result) {
        this.result = result;
    }

}
