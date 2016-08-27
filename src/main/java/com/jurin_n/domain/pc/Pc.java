package com.jurin_n.domain.pc;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Pc {
    @Id
    private String id;
    private String name;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Parts> parts;

    public Pc() {
        super();
    }

    public Pc(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Pc(String id, String name, List<Parts> parts) {
        super();
        this.id = id;
        this.name = name;
        this.parts = parts;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Parts> getParts() {
        return parts;
    }
}
