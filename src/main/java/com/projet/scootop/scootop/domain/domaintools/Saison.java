package com.projet.scootop.scootop.domain.domaintools;

import javax.persistence.*;

import com.projet.scootop.scootop.domain.inprogess.MatchSheet;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity

@Table(name = "Saison")

public class Saison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    //TODO: Supprimer, ajouter getter: concaténation début - fin
    public String name;
    public LocalDate dateDebut;
    public LocalDate dateFin;
    
    //TODO: ajouter line league
    
    @OneToMany
    @JoinColumn(name = "SAISON_ID")
    public List<MatchSheet> matchSheets;

    public Saison(String name, LocalDate dateDebut, LocalDate dateFin, List<MatchSheet> matchSheets) {
        super();
        this.name = name;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.matchSheets = matchSheets;
    }

    public Saison() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public List<MatchSheet> getMatchSheets() {
        return matchSheets;
    }

    public void setMatchSheets(List<MatchSheet> matchSheets) {
        this.matchSheets = matchSheets;
    }
}
