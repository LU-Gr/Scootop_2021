package com.projet.scootop.domain.services.tools;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
public class AgenceType {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String name;

    public AgenceType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AgenceType() {
    }
}
