package com.projet.scootop.scootop.model.domainconfiguration;

import com.projet.scootop.scootop.domain.domainconfiguration.Category;
import com.projet.scootop.scootop.domain.domainconfiguration.Club;
import com.projet.scootop.scootop.domain.domainuser.Coach;
import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.model.ClubDTO;
import com.projet.scootop.scootop.model.domainuser.CoachDTO;

import java.util.List;

public class TeamDTO {

    public Integer id;
    public Club club;
    public String name;
    public List<Coach> coaches;
    public List<Player> players;
    public Category category;

    public  static TeamDTO create(Club club, String name, List<Coach> coaches, List<Player> players, Category category) {
        TeamDTO teamDTO= new TeamDTO();
        teamDTO.club = club;
        teamDTO.name = name;
        teamDTO.coaches = coaches;
        teamDTO.players = players;
        teamDTO.category = category;

        return teamDTO;
    }
    public  static TeamDTO get(Integer id, Club club, String name, List<Coach> coaches, List<Player> players, Category category) {
        TeamDTO teamDTO= new TeamDTO();
        teamDTO.id = id;
        teamDTO.club = club;
        teamDTO.name = name;
        teamDTO.coaches = coaches;
        teamDTO.players = players;
        teamDTO.category = category;

        return teamDTO;
    }

    @Override
    public String toString() {
        return "TeamDTO{" +
                "id=" + id +
                ", club=" + club +
                ", name='" + name + '\'' +
                ", coaches=" + coaches +
                ", players=" + players +
                ", category=" + category +
                '}';
    }
}