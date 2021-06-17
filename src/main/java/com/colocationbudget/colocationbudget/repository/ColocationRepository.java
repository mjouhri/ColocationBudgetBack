package com.colocationbudget.colocationbudget.repository;

import com.colocationbudget.colocationbudget.model.Colocation;
import com.colocationbudget.colocationbudget.model.Type;
import com.colocationbudget.colocationbudget.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ColocationRepository extends BaseRepository {

    private static final String GET_COLOCATION_BY_DATE_EXPENSES = "SELECT c FROM Colocation c JOIN c.expenses e WHERE c.id = :id AND month(e.date) = :month AND year(e.date) = :year ";
    private static final String GET_USERS_OF_COLOCATION = "SELECT c.users FROM Colocation c JOIN c.users where c.id = :id";
    private static final String GET_OWNER_COLOCATION = "SELECT c.owner FROM Colocation c JOIN c.owner where c.id = :id";


    public Long create(Colocation colocation) {
        Session session = getEntityManager().unwrap(Session.class);
        if (colocation != null) {
            return (Long) session.save(colocation);
        }
        return null;
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

    public List<User> getUsersofColocation(Long idColocation){
        Session session = getEntityManager().unwrap(Session.class);
        Query<User> query = session.createQuery(GET_USERS_OF_COLOCATION);
        query.setParameter("id", idColocation);
        return query.getResultList();
    }

    public User getOwerColocation(Long idColocation){
        Session session = getEntityManager().unwrap(Session.class);
        Query<User> query = session.createQuery(GET_OWNER_COLOCATION);
        query.setParameter("id", idColocation);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null ;
    }

}
