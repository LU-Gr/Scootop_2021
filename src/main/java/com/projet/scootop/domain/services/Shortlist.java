package com.projet.scootop.domain.services;

import javax.persistence.*;

import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.domainuser.Player;
import com.projet.scootop.domain.user.domainuser.Scoot;

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

    @ManyToMany
    @JoinTable(name = "shortlist_player", 
	joinColumns = @JoinColumn(name = "shortlist_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"))
    @Getter @Setter
    private List <Player> Players;
    
    @ManyToMany
    @JoinTable(name = "shortlist_scoot", 
	joinColumns = @JoinColumn(name = "shortlist_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "scoot_id", referencedColumnName = "id"))
    @Getter @Setter
    private List <Scoot> Scoots;
    
    @ManyToMany
    @JoinTable(name = "shortlist_team", 
	joinColumns = @JoinColumn(name = "shortlist_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"))
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

