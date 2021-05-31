package com.projet.scootop.domain.user.provider;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.domain.user.User;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Manager")
// AGENT DE JOUEUR != d'un scoot qui travaille pour un club, l'agent sert interet d'un joueur -> c'est un apporteur d'affaires 

public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @OneToOne
    @Getter @Setter
    private User user;
    
    @ManyToOne
    @Getter @Setter
    @JsonIgnoreProperties("managers")
    private Agence agence;

    public Manager(User user, Agence agence) {
        this.user = user;
        this.agence = agence;
    }

    public Manager() {
    }

}
