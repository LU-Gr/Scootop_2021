package com.projet.scootop.scootop.model.services;

import java.util.List;

import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.domaintools.CompetitionType;
import com.projet.scootop.scootop.domain.domaintools.Saison;
import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.inprogess.StatisticalSheet;
import com.projet.scootop.scootop.domain.stastistical.Pass;
import com.projet.scootop.scootop.domain.stastistical.Goal;

public class UserResumeDTO {

    public int id;
    public Player player;
    public CompetitionType competitionType;
    public List<Goal> goals;
    public List<Pass> assists;
    public List<StatisticalSheet> statisticalSheets;
    public List<Saison> saisons;
    public float distance_traveled;
    public List<Team> teams;
    public int ballPlayed;
    public int ballLost;
    public int defensiveSkills;
    public int offensiveSkills;


    public static UserResumeDTO create(Player player, CompetitionType competitionType, List<Goal> goals, List<Pass> assists,List <StatisticalSheet> statisticalSheet, float distance_traveled, List<Team> teams,List<Saison> saisons, int ballPlayed, int ballLost, int defensiveSkills, int offensiveSkills) {
        UserResumeDTO userResumeDTO = new UserResumeDTO();
        userResumeDTO.player = player;
        userResumeDTO.competitionType = competitionType;
        userResumeDTO.goals = goals;
        userResumeDTO.assists = assists;
        userResumeDTO.statisticalSheets = statisticalSheet;
        userResumeDTO.distance_traveled = distance_traveled;
        userResumeDTO.teams = teams;
        userResumeDTO.saisons = saisons;
        userResumeDTO.ballPlayed = ballPlayed;
        userResumeDTO.ballLost = ballLost;
        userResumeDTO.defensiveSkills = defensiveSkills;
        userResumeDTO.offensiveSkills = offensiveSkills;

        return userResumeDTO;
    }

    public static UserResumeDTO get(Integer id,Player player, CompetitionType competitionType, List<Goal> goals, List<Pass> assists,List <StatisticalSheet> statisticalSheet, float distance_traveled, List<Team> teams,List<Saison> saisons, int ballPlayed, int ballLost, int defensiveSkills, int offensiveSkills) {
        UserResumeDTO userResumeDTO = new UserResumeDTO();
        userResumeDTO.id = id;
        userResumeDTO.player = player;
        userResumeDTO.competitionType = competitionType;
        userResumeDTO.goals = goals;
        userResumeDTO.assists = assists;
        userResumeDTO.statisticalSheets = statisticalSheet;
        userResumeDTO.distance_traveled = distance_traveled;
        userResumeDTO.teams = teams;
        userResumeDTO.saisons = saisons;
        userResumeDTO.ballPlayed = ballPlayed;
        userResumeDTO.ballLost = ballLost;
        userResumeDTO.defensiveSkills = defensiveSkills;
        userResumeDTO.offensiveSkills = offensiveSkills;

        return userResumeDTO;
    }

}
