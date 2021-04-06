package com.projet.scootop.scootop.domain.domainconfiguration;

import javax.persistence.*;

//Type compétition (Foot a 11/8/futsal, etc...)
@Entity
@Table(name = "CompetitionType")
public class CompetitionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    String name;


    public CompetitionType(String name) {
        this.name = name;
    }

    public CompetitionType() {
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
