package com.jurin_n.infrastructure.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jurin_n.domain.pcAndParts.Pc;
import com.jurin_n.domain.pcAndParts.PcAndPartsRepository;

public class JPAPcAndPartsRepository implements PcAndPartsRepository {
    @PersistenceContext
    private EntityManager em;

    public JPAPcAndPartsRepository() {
        super();
    }

    public JPAPcAndPartsRepository(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    public void persist(Pc pc) {
        em.persist(pc);
    }
}
