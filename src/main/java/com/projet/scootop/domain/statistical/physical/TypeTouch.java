package com.projet.scootop.domain.statistical.physical;

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
