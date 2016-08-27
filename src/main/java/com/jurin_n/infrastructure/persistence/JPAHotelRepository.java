package com.jurin_n.infrastructure.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jurin_n.domain.hotel.Hotel;
import com.jurin_n.domain.hotel.HotelRepository;

public class JPAHotelRepository implements HotelRepository {
    @PersistenceContext
    private EntityManager em;

    public JPAHotelRepository() {
        super();
    }

    public JPAHotelRepository(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    public Hotel findById(String id) {
        return em.find(Hotel.class, id);
    }

    @Override
    public void persist(Hotel hotel) {
        em.persist(hotel);
    }
}
