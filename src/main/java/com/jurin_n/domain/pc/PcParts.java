package com.jurin_n.domain.pc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.jurin_n.domain.pc.Pc;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "pc_id",
        "partsId" }) )
public class PcParts {
    @Id
    private String id;
    @ManyToOne
    private Pc pc;
    private String partsId;

    public PcParts() {
        super();
    }

    public PcParts(String id, String partsId) {
        super();
        this.id = id;
        this.partsId = partsId;
    }

    public PcParts(String id, String partsId, Pc pc) {
        super();
        this.id = id;
        this.partsId = partsId;
        this.pc = pc;
    }

    public String getId() {
        return id;
    }

    public Pc getPc() {
        return pc;
    }

    public String getPartsId() {
        return partsId;
    }

    public void setPc(Pc pc) {
        this.pc = pc;
    }
}
