package com.projet.scootop.domain.configuration;

import javax.persistence.*;

import com.projet.scootop.domain.user.domainuser.Player;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "Poste")
public class Poste {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String name;
    
    @ManyToMany
    @JoinTable(name = "player_poste", 
	joinColumns = @JoinColumn(name = "poste_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"))
    @Getter @Setter
    private List<Player> players;

    public Poste() {
    }

    public Poste(String name, List<Player> player) {
        super();
        this.name = name;
        this.players = player;
    }
}
