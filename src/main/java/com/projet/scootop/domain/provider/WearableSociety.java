package com.projet.scootop.domain.provider;

import javax.persistence.*;

import com.projet.scootop.domain.user.Contact;

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
