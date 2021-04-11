package com.projet.scootop.domain.services.interaction;

import javax.persistence.*;

import com.projet.scootop.domain.domaintools.Saison;
import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.services.Events;
import com.projet.scootop.domain.user.User;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

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
    private Events events;
    
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


    public Invite(Saison saison, Events events, User user, Player player, LocalDate createAt, boolean response) {
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
