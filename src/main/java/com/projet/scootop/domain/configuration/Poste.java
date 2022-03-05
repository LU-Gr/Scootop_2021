package com.projet.scootop.domain.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.domain.user.domain.Player;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Poste")
public class Poste {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String name;

    // A ENLEVER
    @ManyToMany
    @JoinTable(name = "player_poste", 
	joinColumns = @JoinColumn(name = "poste_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"))
    @Getter @Setter
    @JsonIgnoreProperties({"postes","statisticalSheets"})
    private List<Player> players;

    public Poste() {
    	this.players = new ArrayList<>();
    }

    public Poste(String name, List<Player> player) {
        super();
        this.name = name;
        this.players = player;
    }
}
