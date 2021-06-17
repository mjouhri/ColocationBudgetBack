package com.colocationbudget.colocationbudget.repository;

import com.colocationbudget.colocationbudget.model.Type;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TypeRespository extends BaseRepository{

    private static final String GET_ALL_TYPES = "SELECT t FROM Type t";

    public List<Type> getAll() {
        Session session = getEntityManager().unwrap(org.hibernate.Session.class);
        return session.createQuery(GET_ALL_TYPES, Type.class).list();
    }

}
