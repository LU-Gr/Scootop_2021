package com.projet.scootop.domain.configuration;

import javax.persistence.*;

import com.projet.scootop.domain.tools.Saison;

import lombok.Getter;
import lombok.Setter;

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
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String name;
    
    @OneToMany(orphanRemoval=true, fetch=FetchType.EAGER)
    @Getter @Setter
    private List<Division> divisions;
    
    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private CompetitionType competitionType;
    
    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private Saison saison;
    

    public League() {
    }

    public League(String name) {
        super();
        this.name = name;
        this.divisions=new ArrayList<>();
    }
}