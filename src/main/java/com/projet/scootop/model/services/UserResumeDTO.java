package com.projet.scootop.model.services;

import java.util.List;

import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.domaintools.Competition;
import com.projet.scootop.domain.domaintools.Saison;
import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.inprogress.StatisticalSheet;

public class UserResumeDTO {

    public Long id;
    public Player player;
    public Competition competitionType;
    public List<StatisticalSheet> statisticalSheets;
    public List<Saison> saisons;
    public List<Team> teams;
    public int defensiveSkills;
    public int offensiveSkills;


    public static UserResumeDTO create(Player player, Competition competitionType,List <StatisticalSheet> statisticalSheet, List<Team> teams,List<Saison> saisons,  int defensiveSkills, int offensiveSkills) {
        UserResumeDTO userResumeDTO = new UserResumeDTO();
        userResumeDTO.player = player;
        userResumeDTO.competitionType = competitionType;
        userResumeDTO.statisticalSheets = statisticalSheet;
        userResumeDTO.teams = teams;
        userResumeDTO.saisons = saisons;
        userResumeDTO.defensiveSkills = defensiveSkills;
        userResumeDTO.offensiveSkills = offensiveSkills;

        return userResumeDTO;
    }

    public static UserResumeDTO get(Long id,Player player, Competition competitionType, List <StatisticalSheet> statisticalSheet, List<Team> teams,List<Saison> saisons, int defensiveSkills, int offensiveSkills) {
        UserResumeDTO userResumeDTO = new UserResumeDTO();
        userResumeDTO.id = id;
        userResumeDTO.player = player;
        userResumeDTO.competitionType = competitionType;
        userResumeDTO.statisticalSheets = statisticalSheet;
        userResumeDTO.teams = teams;
        userResumeDTO.saisons = saisons;
        userResumeDTO.defensiveSkills = defensiveSkills;
        userResumeDTO.offensiveSkills = offensiveSkills;

        return userResumeDTO;
    }

}