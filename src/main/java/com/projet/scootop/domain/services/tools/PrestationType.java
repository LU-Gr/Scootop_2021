package com.projet.scootop.domain.services.tools;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
public class PrestationType {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String name;

    public PrestationType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PrestationType() {

    }
}
