package com.projet.scootop.scootop.domain.domainconfiguration;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

//Type compétition (Foot a 11/8/futsal, etc...)
@Entity
@Table(name = "CompetitionType")
public class CompetitionType {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String name;


    public CompetitionType(String name) {
        this.name = name;
    }

    public CompetitionType() {
    }
}
