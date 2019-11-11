package com.elis.product1.product1.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import static java.lang.String.format;

public abstract class DefaultService {

    protected EntityManager em;
    protected JPAQueryFactory jpaQuery;

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Autowired
    public void setJpaQuery(JPAQueryFactory jpaQuery) {
        this.jpaQuery = jpaQuery;
    }

    protected <T, ID> T findByIdOrError(Class<T> clazz, ID id) {
        T t = em.find(clazz, id);
        if (t == null) {
            throw new EntityNotFoundException(format("Entity not found (%s, %s)", clazz.getSimpleName(), id));
        }
        return t;
    }
}
