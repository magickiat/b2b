package com.starboard.b2b.dao;

import com.starboard.b2b.model.Content;

import java.util.List;

/**
 * Created by Ken on 9/29/2015.
 */
public interface ContentDao {

    List list();

    void add(Content content);

}
