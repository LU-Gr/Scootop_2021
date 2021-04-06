package com.projet.scootop.scootop.domain.provider;

import javax.persistence.*;

@Entity
@Table(name = "Manager")
// AGENT DE JOUEUR != d'un scoot qui travaille pour un club, l'agent sert interet d'un joueur -> c'est unn apporteur d'affaires 

public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    // USER?
    public String name;
    @ManyToOne
    public Agence agence;

    public Manager( String name, Agence agence) {
        this.name = name;
        this.agence = agence;
    }

    public Manager() {
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

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }
}
