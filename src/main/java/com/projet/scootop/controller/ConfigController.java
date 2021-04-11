package com.projet.scootop.controller;


import org.springframework.web.bind.annotation.*;

import com.projet.scootop.domain.domainconfiguration.Category;
import com.projet.scootop.domain.domainconfiguration.Club;
import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.domainuser.Coach;
import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.user.User;

import java.util.*;


@RestController
public class ConfigController {

    @GetMapping("")
    Team helloWorld() throws Exception {
        ScootopTest scootopTest = new ScootopTest();
        Category category = new Category();
        ArrayList<Player> Effectif =new ArrayList<>();

        ArrayList<Team> Teamsz = new ArrayList<Team>();
        ArrayList<Coach> CoachesTeams = new ArrayList<Coach>();
        Club club = new Club();
        Team team = new Team();
        Coach coach = new Coach();
        User CoachElite = new User();

        scootopTest.LaunchClub(CoachElite, category, club, team, coach, Effectif, Teamsz, CoachesTeams);


        return  scootopTest.LaunchClub(CoachElite, category, club, team, coach, Effectif, Teamsz, CoachesTeams);
    }

}