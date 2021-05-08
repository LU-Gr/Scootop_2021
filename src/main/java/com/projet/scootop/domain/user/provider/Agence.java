package com.projet.scootop.domain.user.provider;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Agence")
//SERT A GERER L'IMAGE D'UN JOUEUR
public class Agence {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String region;
    
    @OneToMany
    @JoinColumn(name = "agence_id", referencedColumnName = "id")
    @Getter @Setter
    private List<MarketingAdvisor> marketingAdvisors;
    
    @OneToMany
    @JoinColumn(name = "agence_id", referencedColumnName = "id")
    @Getter @Setter
    private List<Manager> manager;

    public Agence( String region, List<MarketingAdvisor> marketingAdvisors, List<Manager> manager) {
        super();
        this.region = region;
        this.marketingAdvisors = marketingAdvisors;
        this.manager = manager;
    }

    public Agence() {
    }
}
