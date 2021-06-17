package com.colocationbudget.colocationbudget.repository;

import com.colocationbudget.colocationbudget.model.Spend;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class SpendRepository extends BaseRepository{

    public Long create(Spend spend) {
        Session session = getEntityManager().unwrap(Session.class);
        if (spend != null) {
            return (Long) session.save(spend);
        }
        return null;
    }

    public Spend getById(Long idSpend) {
        Session session = getEntityManager().unwrap(Session.class);
        if (idSpend != null) {
            return session.get(Spend.class, idSpend);
        }
        return null;
    }

}
