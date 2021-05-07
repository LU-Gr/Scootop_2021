package com.projet.scootop.controller;


import org.springframework.web.bind.annotation.*;

import com.projet.scootop.domain.configuration.Category;
import com.projet.scootop.domain.tools.Club;
import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.domainuser.Coach;
import com.projet.scootop.domain.user.domainuser.Player;

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
