package com.projet.scootop.scootop.domain.domainconfiguration;

import com.projet.scootop.scootop.domain.user.Contact;

import javax.persistence.*;

/*
 * TODO: Ajouter:
 * - -+ :
 * - Lattitude/longitude
 */
@Entity
@Table(name = "Stadium")

public class Stade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    @OneToOne(orphanRemoval=true)
    @JoinColumn(name = "CONTACT_ID")
    public Contact contact;

    public Stade( String name,Contact contact) {
        super();
        this.name = name;
        this.contact = contact;
    }

    public Stade() {
    }
}
