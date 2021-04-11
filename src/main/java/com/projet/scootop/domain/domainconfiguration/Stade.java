package com.projet.scootop.domain.domainconfiguration;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.projet.scootop.domain.user.Contact;

/*
 * TODO: Ajouter:
 * - -+ :
 * - Lattitude/longitude
 */
@Entity
@Table(name = "stade")

public class Stade {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String name;
    
    @OneToOne(orphanRemoval=true)
    @JoinColumn(name = "CONTACT_ID")
    @Getter @Setter
    private Contact contact;

    public Stade( String name,Contact contact) {
        super();
        this.name = name;
        this.contact = contact;
    }

    public Stade() {
    }
}
