package com.projet.scootop.domain.domaintools;

import javax.persistence.*;

import com.projet.scootop.domain.domainconfiguration.League;
import com.projet.scootop.domain.inprogress.MatchSheet;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity

@Table(name = "Saison")

public class Saison {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    
    @Getter @Setter
    private LocalDate dateDebut;
    
    @Getter @Setter
    private LocalDate dateFin;
    
    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private League league;
    
    @OneToMany
    @JoinColumn(name = "SAISON_ID")
    @Getter @Setter
    private List<MatchSheet> matchSheets;

    public Saison(LocalDate dateDebut, LocalDate dateFin, List<MatchSheet> matchSheets) {
        super();
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.matchSheets = matchSheets;
    }

    public Saison() {
    }

    public String getName() {
        return dateDebut.toString() + " - " + dateFin.toString();
    }
}
