package com.jurin_n.domain.hotel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "id",
        "hotel_id" }) )
public class Room {
    @Id
    private String id;
    private String name;
    @ManyToOne
    private Hotel hotel;

    public Room() {
        super();
    }

    public Room(String id, String name, Hotel hotel) {
        super();
        this.id = id;
        this.name = name;
        this.hotel = hotel;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Hotel getHotel() {
        return hotel;
    }
}
