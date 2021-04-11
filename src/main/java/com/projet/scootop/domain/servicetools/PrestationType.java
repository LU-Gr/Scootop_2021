package com.projet.scootop.domain.servicetools;

import javax.persistence.*;

@Entity
@Table(name="Prestation_TYPE")

public class PrestationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String Name;
    /*@OneToMany
    public Prestation prestation;*/

    public PrestationType(int id, String name) {
        this.id = id;
        Name = name;
    }

    public PrestationType() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
