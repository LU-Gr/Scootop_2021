package com.projet.scootop.scootop.model.services;

import com.projet.scootop.scootop.domain.domainconfiguration.Stadium;
import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.inprogess.StatisticalSheet;
import com.projet.scootop.scootop.domain.services.Events;
import com.projet.scootop.scootop.user.User;

import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

public class GameSheetDTO {
    int id;
    public User user;
    public List<Team> teams;
    public List<StatisticalSheet> stactisticalSheets;
    public Stadium stade;
    public Events events;
    public Date date;

    public static GameSheetDTO create(int id, User user, List<Team> teams, List<StatisticalSheet> stactisticalSheets, Stadium stade, Events events, Date date) {
        GameSheetDTO gamesheet = new GameSheetDTO();

        gamesheet.id = id;
        gamesheet.user = user;
        gamesheet.teams = teams;
        gamesheet.stactisticalSheets = stactisticalSheets;
        gamesheet.stade = stade;
        gamesheet.events = events;
        gamesheet.date = date;

        return gamesheet;
    }

    public static GameSheetDTO get(int id, User user, List<Team> teams, List<StatisticalSheet> stactisticalSheets, Stadium stade, Events events, Date date) {
        GameSheetDTO gamesheet = new GameSheetDTO();

        gamesheet.id = id;
        gamesheet.user = user;
        gamesheet.teams = teams;
        gamesheet.stactisticalSheets = stactisticalSheets;
        gamesheet.stade = stade;
        gamesheet.events = events;
        gamesheet.date = date;

        return gamesheet;
    }
}
