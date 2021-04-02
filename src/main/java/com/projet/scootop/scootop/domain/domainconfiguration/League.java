package com.projet.scootop.scootop.domain.domainconfiguration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Exemples: 
 * France 18+: Divisions: [L1,L2,L3]
 * France U-19: Divisions: [U19-Nationaux, ...]
 */
@Entity
@Table(name = "League")
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    @OneToMany(orphanRemoval=true, fetch=FetchType.EAGER)
    public List<Division> divisions;
    
    //TODO: Ajouter CompetitionType
    //TODO: Ajouter Saison

    public League() {
    }

    public League(String name) {
        super();
        this.name = name;
        this.divisions=new ArrayList<>();
    }
}