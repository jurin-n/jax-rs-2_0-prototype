package com.jurin_n.domain.pcAndParts;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Pc2 {
    @Id
    private String id;
    private String name;
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Parts2> parts;

    public Pc2() {
        super();
    }

    public Pc2(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Pc2(String id, String name, List<Parts2> parts) {
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

    public List<Parts2> getParts() {
        return parts;
    }
}
