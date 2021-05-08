package com.projet.scootop.domain.services.tools;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="PrestationType")
public class PrestationType {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int id;
    
    @Getter @Setter
    private String Name;

    public PrestationType(int id, String name) {
        this.id = id;
        Name = name;
    }

    public PrestationType() {

    }
}
