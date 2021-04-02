package com.projet.scootop.scootop.domain.domaintools;

import javax.persistence.*;

// différents skills: Exemple: Controle
@Entity
@Table(name = "Skill")

public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;

    public Skill( String name) {
        super();
        this.name = name;
    }

    public Skill() {
    }
}
