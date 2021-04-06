package com.projet.scootop.scootop.domain.stastistical.physical;

import javax.persistence.*;

@Entity
@Table(name = "TYPE_SHOOT")
public class TypeTouch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String physical;

    public TypeTouch(String physical) {
        super();
        this.physical = physical;
    }

    public TypeTouch() {
    }
}
