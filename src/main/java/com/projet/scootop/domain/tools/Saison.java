package com.projet.scootop.domain.tools;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    
    @OneToMany
    @JoinColumn(name="saison_id", referencedColumnName="id")
    @Getter @Setter
    @JsonIgnoreProperties("saison")
    private List<Match> matchs;

    public Saison(LocalDate dateDebut, LocalDate dateFin, List<Match> matchSheets) {
        super();
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.matchs = matchSheets;
    }

    public Saison() {
    }

    public String getName() {
        return dateDebut.toString() + " - " + dateFin.toString();
    }
    
    public String getNameByYears() {
        return dateDebut.getYear() + " - " + dateFin.getYear();
    }
}
