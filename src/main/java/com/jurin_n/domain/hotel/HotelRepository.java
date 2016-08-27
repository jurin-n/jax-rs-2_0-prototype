package com.jurin_n.domain.hotel;

public interface HotelRepository {
    public Hotel findById(String id);
    public void persist(Hotel hotel);
}
