package com.projet.scootop.domain.services.interaction;

import javax.persistence.*;

import com.projet.scootop.domain.domaintools.Saison;
import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.user.User;

import java.time.LocalDate;

@Entity
@Table(name = "Follow")

public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public LocalDate dateCreated;

    @ManyToOne
    public User user;
    @ManyToOne
    public Player player;
    @ManyToOne
    public Saison saison;


    public Follow() {
    }

    public Follow(LocalDate dateCreated, User user, Player player, Saison saison) {
        super();
        this.dateCreated = dateCreated;
        this.user = user;
        this.player = player;
        this.saison = saison;
    }
}
