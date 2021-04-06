package com.projet.scootop.scootop.domain.provider;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Agence")
//SERT A GERER L'IMAGE D'UN JOUEUR
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String region;
    @OneToMany
    @JoinColumn(name = "MaketingAdvisor_id")
    public List<MarketingAdvisor> marketingAdvisors;
    @OneToMany
    @JoinColumn(name = "manager_id")
    public List<Manager> manager;


    public Agence( String region, List<MarketingAdvisor> marketingAdvisors, List<Manager> manager) {
        super();
        this.region = region;
        this.marketingAdvisors = marketingAdvisors;
        this.manager = manager;
    }

    public Agence() {
    }
}
