package com.projet.scootop.domain.services;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.domain.Player;
import com.projet.scootop.domain.user.domain.Scoot;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Shortlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    // ??
    @Getter @Setter
    private int rank;
    
    @OneToOne
    @Getter @Setter
    private User user;

    @ManyToMany
    @JoinTable(name = "shortlist_player", 
	joinColumns = @JoinColumn(name = "shortlist_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"))
    @Getter @Setter
    private List<Player> players;
    
    @ManyToMany
    @JoinTable(name = "shortlist_scoot", 
	joinColumns = @JoinColumn(name = "shortlist_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "scoot_id", referencedColumnName = "id"))
    @Getter @Setter
    @JsonIgnoreProperties("shortlists")
    private List<Scoot> scoots;
    
    @ManyToMany
    @JoinTable(name = "shortlist_team", 
	joinColumns = @JoinColumn(name = "shortlist_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"))
    @Getter @Setter
    private List<Team> teams;

    

    public Shortlist() {

    }

    public Shortlist(User user) {
    	this.user = user;
    }

}

