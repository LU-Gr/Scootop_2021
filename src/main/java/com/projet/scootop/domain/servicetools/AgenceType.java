package com.projet.scootop.domain.servicetools;

import javax.persistence.*;

@Entity
@Table(name="Agence_TYPE")
public class AgenceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String Name;

    public AgenceType(int id, String name) {
        this.id = id;
        Name = name;
    }

    public AgenceType() {
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
