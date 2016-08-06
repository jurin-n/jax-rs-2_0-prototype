package com.jurin_n.domain.team;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Team
 *
 */
@Entity
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;

    public Team() {
        super();
    }

    public Team(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
