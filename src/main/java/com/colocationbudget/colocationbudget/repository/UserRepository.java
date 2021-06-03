package com.colocationbudget.colocationbudget.repository;

import com.colocationbudget.colocationbudget.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends BaseRepository{

    private static final String GET_USER_BY_MAIL_QUERY = "SELECT u FROM User u WHERE u.email = :email ";


    public void create(User user) {
        Session session = getEntityManager().unwrap(Session.class);
        if (user != null) {
            session.save(user);
        }
    }

    public User getById(Long idUser) {
        Session session = getEntityManager().unwrap(Session.class);
        if (idUser != null) {
            return session.get(User.class, idUser);
        }
        return null;
    }

    public User getByMail(String mail) {
        Session session = getEntityManager().unwrap(Session.class);
        Query<User> query = session.createQuery(GET_USER_BY_MAIL_QUERY);
        query.setParameter("email", mail);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null ;
    }

    public void update(User user) {
        Session session = getEntityManager().unwrap(Session.class);
        if (user != null) {
            session.update(user);
        }
    }

    public void delete(User user) {
        Session session = getEntityManager().unwrap(Session.class);
        if (user != null) {
            session.delete(session.merge(user));
        }
    }

}
