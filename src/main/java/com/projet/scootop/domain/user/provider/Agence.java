package com.projet.scootop.domain.user.provider;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Entity
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
    @JsonIgnoreProperties("agence")
    private List<MarketingAdvisor> marketingAdvisors;
    
    @OneToMany
    @JoinColumn(name = "agence_id", referencedColumnName = "id")
    @Getter @Setter
    @JsonIgnoreProperties("agence")
    private List<Manager> managers;

    public Agence( String region, List<MarketingAdvisor> marketingAdvisors, List<Manager> managers) {
        super();
        this.region = region;
        this.marketingAdvisors = marketingAdvisors;
        this.managers = managers;
    }

    public Agence() {
    }
}
