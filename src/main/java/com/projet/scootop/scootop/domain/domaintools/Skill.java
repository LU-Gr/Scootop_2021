package com.projet.scootop.scootop.domain.domaintools;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

// différents skills: Exemple: Controle
@Entity
@Table(name = "Skill")

public class Skill {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String name;

    public Skill( String name) {
        super();
        this.name = name;
    }

    public Skill() {
    }
}
