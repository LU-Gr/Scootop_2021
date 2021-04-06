package com.projet.scootop.scootop.domain.provider;

import com.projet.scootop.scootop.domain.user.Contact;

import javax.persistence.*;

@Entity
@Table(name = "WearableSociety")


public class WearableSociety {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    // <> name?
    public String societe;
    public String ceo;
    // ??
    public String specialite;
    // tarif de?
    public Integer tarif;
    @OneToOne
    public Contact contact;

    public WearableSociety() {

    }

    public WearableSociety(String name, String societe, String ceo, String specialite, Integer tarif, Contact contact) {
        super();
        this.name = name;
        this.societe = societe;
        this.ceo = ceo;
        this.specialite = specialite;
        this.tarif = tarif;
        this.contact = contact;
    }
}
