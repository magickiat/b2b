package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.TmpSoDao;
import com.starboard.b2b.model.TmpSo;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tmpSoDao")
public class TmpSoDaoImpl implements TmpSoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(TmpSo tmpSo) {
        sessionFactory.getCurrentSession().save(tmpSo);
    }

    @Override
    public TmpSo findBySoId(long soId) {
        return (TmpSo) sessionFactory.getCurrentSession()
                .get(TmpSo.class, soId);
    }

    @Override
    public void remove(long soId) {
        TmpSo deleteObject = findBySoId(soId);
        if(deleteObject != null){
            sessionFactory.getCurrentSession()
                    .delete(deleteObject);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TmpSo> list() {
        return sessionFactory.getCurrentSession().createCriteria(TmpSo.class).list();
    }

    @Override
    public void removeAll() {
        final String hql = "DELETE FROM TmpSo";
        sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
    }
}
