package com.colocationbudget.colocationbudget.repository;

import com.colocationbudget.colocationbudget.model.Colocation;
import com.colocationbudget.colocationbudget.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ColocationRepository extends BaseRepository {

    private static final String GET_COLOCATION_BY_DATE_EXPENSES = "SELECT c FROM Colocation c JOIN c.expenses e WHERE c.id = :id AND month(e.date) = :month AND year(e.date) = :year ";



    public void create(Colocation colocation) {
        Session session = getEntityManager().unwrap(Session.class);
        if (colocation != null) {
            session.save(colocation);
        }
    }

    public Colocation getById(Long idColocation) {
        Session session = getEntityManager().unwrap(Session.class);
        if (idColocation != null) {
            return session.get(Colocation.class, idColocation);
        }
        return null;
    }

    public Colocation getById(Long idColocation, int month, int year) {
        Session session = getEntityManager().unwrap(Session.class);
        Query<Colocation> query = session.createQuery(GET_COLOCATION_BY_DATE_EXPENSES);
        query.setParameter("id", idColocation);
        query.setParameter("month", month);
        query.setParameter("year", year);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null ;
    }

    public void update(Colocation colocation) {
        Session session = getEntityManager().unwrap(Session.class);
        if (colocation != null) {
            session.update(colocation);
        }
    }




}
