package com.projet.scootop.scootop.domain.provider;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Agence")

public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
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
