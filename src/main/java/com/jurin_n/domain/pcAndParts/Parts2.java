package com.jurin_n.domain.pcAndParts;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Parts2 {
    @Id
    private String id;
    private String name;
    @ManyToMany(mappedBy = "parts")
    private List<Pc2> pcs;

    public Parts2() {
        super();
    }

    public Parts2(String id, String name) {
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

    public List<Pc2> getPcs() {
        return pcs;
    }
}
