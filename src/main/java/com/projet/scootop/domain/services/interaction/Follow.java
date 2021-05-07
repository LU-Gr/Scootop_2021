package com.projet.scootop.domain.services.interaction;

import javax.persistence.*;

import com.projet.scootop.domain.tools.Saison;
import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.domainuser.Player;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Follow")

public class Follow {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private LocalDate dateCreated;

    @ManyToOne
    @Getter @Setter
    private User user;
    
    @ManyToOne
    @Getter @Setter
    private Player player;
    
    @ManyToOne
    @Getter @Setter
    private Saison saison;


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
