package com.jurin_n.domain.parts;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parts {
    @Id
    private String id;
    private String name;

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
}
