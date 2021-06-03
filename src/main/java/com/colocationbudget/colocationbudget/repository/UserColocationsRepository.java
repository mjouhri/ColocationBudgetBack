package com.colocationbudget.colocationbudget.repository;

import com.colocationbudget.colocationbudget.model.UserColocation;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserColocationsRepository extends BaseRepository{

    private static final String GET_USER_COLOCATIONS_BY_ID_USER_QUERY = "SELECT uc FROM UserColocation uc WHERE uc.user.id = :idUser";
    //private static final String GET_COLOCATIONS_ = "SELECT uc FROM UserColocation uc WHERE uc.user.id = :idUser JOIN uc.colocations ";



    public UserColocation getById(Long id) {
        Session session = getEntityManager().unwrap(Session.class);
        Query<UserColocation> query = session.createQuery(GET_USER_COLOCATIONS_BY_ID_USER_QUERY);
        query.setParameter("idUser", id);
        return query.getResultList().size() > 0 ? query.getResultList().get(0) : null ;
    }

//    public Integer getNbColocationsByIdUser(Long id) {
//        Session session = getEntityManager().unwrap(Session.class);
//        Query<UserColocation> query = session.createQuery(GET_USER_COLOCATIONS_BY_ID_USER_QUERY);
//        query.setParameter("idUser", id);
//        return query.getResultList().size();
//    }

}
