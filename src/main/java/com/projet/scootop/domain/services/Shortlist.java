package com.projet.scootop.domain.services;

import javax.persistence.*;

import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.domainuser.Scoot;
import com.projet.scootop.domain.user.User;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Shortlist")

public class Shortlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @OneToOne
    @Getter @Setter
    private User user;

    @OneToMany
    @Getter @Setter
    private List <Player> Players;
    
    @OneToMany
    @Getter @Setter
    private List <Scoot> Scoots;
    
    @OneToMany
    @Getter @Setter
    private List <Team> Teams;

    // ??
    @Getter @Setter
    private int rank;

    public Shortlist() {

    }

    public Shortlist(User user, List<Player> players, List<Scoot> scoots, List<Team> teams, int rank) {
    }

}

