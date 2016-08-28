package com.jurin_n.domain.pc;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pc {
    @Id
    private String id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pc", cascade = CascadeType.ALL)
    private List<PcParts> pcParts;

    public Pc() {
        super();
    }

    public Pc(String id, String name, List<PcParts> pcParts) {
        super();
        this.id = id;
        this.name = name;
        this.pcParts = pcParts;
    }

    public Pc(String id, String name) {
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

    public List<PcParts> getPcParts() {
        return pcParts;
    }

    public void setPcParts(List<PcParts> pcParts) {
        this.pcParts = pcParts;
    }
}
