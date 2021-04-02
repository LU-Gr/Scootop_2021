package com.projet.scootop.scootop.domain.domainconfiguration;

import javax.persistence.*;

/*
 * Exemple: Ligue 1
 */
@Entity
@Table(name = "Division")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    
    @ManyToOne
    @JoinColumn(name = "divisions_id" )
    public League league;
    
    //TODO: Ajouter Category

    public Division(){
    }

    public Division( String name) {
        super();
        this.name = name;
    }
}
