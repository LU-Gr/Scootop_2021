package com.projet.scootop.model.services;


import java.util.List;

import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.domainuser.Scoot;
import com.projet.scootop.domain.user.User;

public class ShortlistDTO {
	Long id;
    public User user;
    public List <Player> Players;
    public List <Scoot> Scoots;
    public List <Team> Teams;

    public int rank;

    public static ShortlistDTO create(Long id, User user, List<Player> players, List<Scoot> scoots, List<Team> teams, int rank) {
        ShortlistDTO shortlist = new ShortlistDTO();

        shortlist.id = id;
        shortlist.user = user;
        shortlist.Players = players;
        shortlist.Scoots = scoots;
        shortlist.Teams = teams;

        return shortlist;
    }

    public static ShortlistDTO get(Long id, User user, List<Player> players, List<Scoot> scoots, List<Team> teams, int rank) {
        ShortlistDTO shortlist = new ShortlistDTO();

        shortlist.id = id;
        shortlist.user = user;
        shortlist.Players = players;
        shortlist.Scoots = scoots;
        shortlist.Teams = teams;

        return shortlist;
    }
}
