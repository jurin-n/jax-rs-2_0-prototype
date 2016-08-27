package com.jurin_n.domain.pc;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Parts {
    @Id
    private String id;
    private String name;
    @ManyToMany(mappedBy = "parts")
    private List<Pc> pcs;

    public Parts() {
        super();
    }

    public Parts(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Pc> getPcs() {
        return pcs;
    }
}
