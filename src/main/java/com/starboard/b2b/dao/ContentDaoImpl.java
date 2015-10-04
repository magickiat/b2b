package com.starboard.b2b.dao;

import com.starboard.b2b.model.Content;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ken on 9/29/2015.
 */
@Repository
public class ContentDaoImpl implements ContentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Content> list() {
        return sessionFactory.getCurrentSession().createCriteria(Content.class).list();
    }

    @Override
    public void add(Content content) {
        sessionFactory.getCurrentSession().save(content);
    }

}
