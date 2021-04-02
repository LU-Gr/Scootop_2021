package com.projet.scootop.scootop.domain.services.interaction;

import com.projet.scootop.scootop.domain.domaintools.Saison;
import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.user.User;
import com.projet.scootop.scootop.user.UserType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Alert")
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public LocalDate dateCreated;
    @ManyToOne
    public User user;
    @ManyToOne
    public Player player;
    @ManyToOne
    public Saison saison;

    public Alert() {

    }

    public Alert(LocalDate dateCreated, User user, Player player, Saison saison)  {
        super();
        this.dateCreated = dateCreated;
        this.user = user;
        this.player = player;
        this.saison = saison;
    }
}
