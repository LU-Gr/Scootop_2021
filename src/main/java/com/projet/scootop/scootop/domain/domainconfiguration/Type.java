package com.projet.scootop.scootop.domain.domainconfiguration;

import javax.persistence.*;

//Type compétition (Foot a 11/8/futsal, etc...)
@Entity
@Table(name = "Type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    String name;


    public Type( String name) {
        this.name = name;
    }

    public Type() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
