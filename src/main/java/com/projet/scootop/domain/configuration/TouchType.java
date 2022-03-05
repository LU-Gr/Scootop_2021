package com.projet.scootop.domain.configuration;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

// Type de touche ( Tete, pieds, torse)
@Entity
@Table(name = "TouchType")
public class TouchType {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String name;

    public TouchType(String name) {
        this.name = name;
    }

    public TouchType() {
    }
}
