package com.projet.scootop.model.services;

import java.util.Date;
import java.util.List;

import com.projet.scootop.domain.domainconfiguration.Stade;
import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.inprogress.StatisticalSheet;
import com.projet.scootop.domain.services.Events;
import com.projet.scootop.domain.user.User;

public class GameSheetDTO {
	Long id;
    public User user;
    public List<Team> teams;
    public List<StatisticalSheet> stactisticalSheets;
    public Stade stade;
    public Events events;
    public Date date;

    public static GameSheetDTO create(Long id, User user, List<Team> teams, List<StatisticalSheet> stactisticalSheets, Stade stade, Events events, Date date) {
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

    public static GameSheetDTO get(Long id, User user, List<Team> teams, List<StatisticalSheet> stactisticalSheets, Stade stade, Events events, Date date) {
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
