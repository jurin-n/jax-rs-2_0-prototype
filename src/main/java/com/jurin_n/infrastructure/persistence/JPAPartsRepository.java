package com.jurin_n.infrastructure.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jurin_n.domain.parts.Parts;
import com.jurin_n.domain.parts.PartsRepository;

public class JPAPartsRepository implements PartsRepository {
    @PersistenceContext
    private EntityManager em;

    public JPAPartsRepository() {
        super();
    }

    public JPAPartsRepository(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    public Parts findById(String id) {
        return em.find(Parts.class, id);
    }

    @Override
    public void persist(Parts parts) {
        em.persist(parts);
    }
}
