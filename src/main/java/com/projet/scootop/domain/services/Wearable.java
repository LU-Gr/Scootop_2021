package com.projet.scootop.domain.services;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Wearable")

public class Wearable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    @Column(unique = true)
    private String identifiant;
    
    @OneToMany
    @JoinColumn(name = "wearable_id", referencedColumnName = "id")
    @Getter @Setter
    private List<LocationWearable> locations;
    
    public Wearable() {

    }

}
