package com.projet.scootop.controller;

import java.util.*;

import com.projet.scootop.domain.domainconfiguration.Category;
import com.projet.scootop.domain.domainconfiguration.Club;
import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.domainuser.Coach;
import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.domainuser.Scoot;
import com.projet.scootop.domain.user.Contact;
import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.UserType;

public class ScootopTest {


    public Team LaunchClub (User CoachElite, Category category, Club club, Team team, Coach coach, ArrayList<Player> Effectif,  ArrayList<Team> Teamsz, ArrayList<Coach> CoachesTeams){

        category.setName("U19");
        ArrayList<UserType> types = new ArrayList<UserType>();
        UserType CoachType = new UserType();
        CoachType.setType("coach");
        types.add(CoachType);

        User ScootBots = new User();
        ScootBots.setLastName("Scoot");
        ScootBots.setFirstName("Bots");
        Contact BotsContacts = new Contact();
        BotsContacts.setUser(ScootBots);

        Scoot ScootMU = new Scoot();
        ScootMU.setUser(ScootBots);

        ArrayList<Scoot> ScootsClub = new ArrayList<Scoot>();
        ScootsClub.add(ScootMU);

        club.setScoots(ScootsClub);

        club.setName("Man Utd");
        club.setColorInside("Red");
        club.setColorOutSide("White");
        club.setContact(BotsContacts);
        Teamsz.add(team);
        team.setCategory(category);
        //club.setTeams(Teamsz);


        CoachElite.setLastName("Raphael Benitez");
        CoachElite.setTypes(types);
        coach.setUser(CoachElite);
        CoachesTeams.add(coach);
        team.setCoaches(CoachesTeams);
        team.setClub(club);

            Player Keeper = new Player();
            Effectif.add(Keeper);
            Player Lateral_Gauche = new Player();
            Effectif.add(Lateral_Gauche);
            Player Lateral_Droit = new Player();
            Effectif.add(Lateral_Droit);
            Player Right_Sweeper = new Player();
            Effectif.add(Right_Sweeper);
            Player Left_Sweeper = new Player();
            Effectif.add(Left_Sweeper);
            Player Center_Midfield_L = new Player();
            Effectif.add(Center_Midfield_L);
            Player Center_Midfield_R = new Player();
            Effectif.add(Center_Midfield_R);
            Player L_Wing_Back = new Player();
            Effectif.add(L_Wing_Back);
            Player R_Wing_Back = new Player();
            Effectif.add(R_Wing_Back);
            Player Forward_R = new Player();
            Effectif.add(Forward_R);
            Player Forward_L = new Player();
            Effectif.add(Forward_L);

        team.setPlayers(Effectif);

        return team;

    }
}
