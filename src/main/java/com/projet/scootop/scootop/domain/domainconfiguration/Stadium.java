package com.projet.scootop.scootop.domain.domainconfiguration;

import com.projet.scootop.scootop.user.Contact;

import javax.persistence.*;

/*
 * TODO: Ajouter:
 * - -+ :
 * - Lattitude/longitude
 */
@Entity
@Table(name = "Stadium")

public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    @OneToOne(orphanRemoval=true)
    @JoinColumn(name = "CONTACT_ID")
    public Contact contact;

    public Stadium( String name,Contact contact) {
        super();
        this.name = name;
        this.contact = contact;
    }

    public Stadium() {
    }
}
