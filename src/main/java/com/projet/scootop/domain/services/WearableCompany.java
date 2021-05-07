package com.projet.scootop.domain.services;

import javax.persistence.*;

import com.projet.scootop.domain.user.Contact;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WearableSociety")
public class WearableCompany {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String societe;
    
    // user?
    @Getter @Setter
    private String ceo;
    
    // ??
    @Getter @Setter
    private String specialite;
    
    // tarif de?
    @Getter @Setter
    private Integer tarif;
    
    // un seul contact?
    @OneToOne
    @Getter @Setter
    private Contact contact;

    public WearableCompany() {

    }

    public WearableCompany(String societe, String ceo, String specialite, Integer tarif, Contact contact) {
        super();
        this.societe = societe;
        this.ceo = ceo;
        this.specialite = specialite;
        this.tarif = tarif;
        this.contact = contact;
    }
}
