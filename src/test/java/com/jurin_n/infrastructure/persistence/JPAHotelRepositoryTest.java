package com.jurin_n.infrastructure.persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.jurin_n.domain.hotel.Hotel;
import com.jurin_n.domain.hotel.Room;
import com.jurin_n.junit.rules.JPAResource;

public class JPAHotelRepositoryTest {
    JPAHotelRepository sut;

    @Rule
    public JPAResource jpa = new JPAResource();

    @Before
    public void setUp() {
        sut = new JPAHotelRepository(jpa.getEm());
    }

    @After
    public void tearDown() {
        sut = null;
    }

    @Test
    public void test() {
        Hotel hotel = new Hotel("001","Hotel Tokyo");
        List<Room> rooms = Arrays.asList(new Room("101","No101",hotel),
                new Room("102","No102",hotel));
        hotel.setRooms(rooms);

        jpa.getEm().getTransaction().begin();
        sut.persist(hotel);
        // データベースへの反映,コンテキスト破棄
        jpa.getEm().flush();
        jpa.getEm().clear();
        jpa.getEm().getTransaction().commit();
    }

    @Test
    public void test2() {
        Hotel hotel2 = sut.findById("001");
        jpa.getEm().refresh(hotel2);

        assertThat(hotel2.getRooms().size(), is(2));
    }
}
