package com.projet.scootop.scootop.model.services;


import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.domainuser.Scoot;
import com.projet.scootop.scootop.user.User;

import javax.persistence.OneToMany;
import java.util.List;

public class ShortlistDTO {
    int id;
    public User user;
    public List <Player> Players;
    public List <Scoot> Scoots;
    public List <Team> Teams;

    public int rank;

    public static ShortlistDTO create(Integer id, User user, List<Player> players, List<Scoot> scoots, List<Team> teams, int rank) {
        ShortlistDTO shortlist = new ShortlistDTO();

        shortlist.id = id;
        shortlist.user = user;
        shortlist.Players = players;
        shortlist.Scoots = scoots;
        shortlist.Teams = teams;

        return shortlist;
    }

    public static ShortlistDTO get(Integer id, User user, List<Player> players, List<Scoot> scoots, List<Team> teams, int rank) {
        ShortlistDTO shortlist = new ShortlistDTO();

        shortlist.id = id;
        shortlist.user = user;
        shortlist.Players = players;
        shortlist.Scoots = scoots;
        shortlist.Teams = teams;

        return shortlist;
    }
}
