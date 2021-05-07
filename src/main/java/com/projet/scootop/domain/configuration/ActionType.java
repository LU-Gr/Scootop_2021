package com.projet.scootop.domain.configuration;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

// différents skills: Exemple: Controle
@Entity
@Table(name = "Skill")

public class ActionType {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String name;

    public ActionType( String name) {
        super();
        this.name = name;
    }

    public ActionType() {
    }
}
