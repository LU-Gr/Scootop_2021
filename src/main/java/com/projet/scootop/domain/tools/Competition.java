package com.projet.scootop.domain.tools;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.projet.scootop.domain.configuration.Category;
import com.projet.scootop.domain.configuration.CompetitionType;
import com.projet.scootop.domain.services.tools.video.Video;

import lombok.Getter;
import lombok.Setter;

// Caractéristique d'une compétiton
@Entity
public class Competition {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String name;
    
    @Getter @Setter
    private int nbPlayerMax;
    
    @Getter @Setter
    private int nbPlayerMin;

    @Getter @Setter
    private int nbTitulaire;
    
    @Getter @Setter
    private int nbRemplacant;

    @Getter @Setter
    private int nbSubstition;

    @Getter @Setter
    private int dureeMiTemps;
    
    @ManyToOne
    @Getter @Setter
    private CompetitionType competitionType; 

    public Competition(String name, Video video, int playerMax, int playerMin, int titulaire, int remplacant, int substition, int time, Category category) {
        super();
        this.name = name;
        this.nbPlayerMax = playerMax;
        this.nbPlayerMin = playerMin;
        this.nbTitulaire = titulaire;
        this.nbRemplacant = remplacant;
        this.nbSubstition = substition;
        this.dureeMiTemps = time;
    }

    public Competition() {

    }
}
