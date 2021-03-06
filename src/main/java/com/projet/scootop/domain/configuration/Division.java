package com.projet.scootop.domain.configuration;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/*
 * Exemple: Ligue 1
 */
@Entity
@Table(name = "Division")
public class Division {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String name;
    
    @ManyToOne
    @JoinColumn
    @Getter @Setter
    @JsonIgnoreProperties("divisions")
    private League league;
    
    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private Category category;
    
    
    public Division(){
    }

    public Division( String name) {
        super();
        this.name = name;
    }  
}
