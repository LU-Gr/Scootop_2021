package com.projet.scootop.domain.services.interaction;

import javax.persistence.*;

import com.projet.scootop.domain.services.Event;
import com.projet.scootop.domain.tools.Saison;
import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.domain.Player;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

//Inviter un joueur pour une session d'entrainement, un evenement sportif
@Entity
@Table(name = "Invite")

public class Invite {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @ManyToOne
    @Getter @Setter
    private Saison saison;

    @ManyToOne
    @Getter @Setter
    private Event events;
    
    @ManyToOne
    @Getter @Setter
    private User user;
    
    @ManyToOne
    @Getter @Setter
    private Player player;
    
    @Getter @Setter
    private LocalDate createAt;
    
    @Getter @Setter
    private boolean response;


    public Invite(Saison saison, Event events, User user, Player player, LocalDate createAt, boolean response) {
        this.saison = saison;
        this.events = events;
        this.user = user;
        this.player = player;
        this.createAt = createAt;
        this.response = response;
    }

    public Invite() {

    }

}
