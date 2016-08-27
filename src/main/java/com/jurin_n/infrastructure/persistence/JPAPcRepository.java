package com.jurin_n.infrastructure.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jurin_n.domain.pc.Pc;
import com.jurin_n.domain.pc.PcRepository;

public class JPAPcRepository implements PcRepository {
    @PersistenceContext
    private EntityManager em;

    public JPAPcRepository() {
        super();
    }

    public JPAPcRepository(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    public void persist(Pc pc) {
        em.persist(pc);
    }
}
