package com.projet.scootop.model.inprogress;

import java.util.List;

import com.projet.scootop.domain.domainconfiguration.Stade;
import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.domaintools.Competition;
import com.projet.scootop.domain.domaintools.Saison;
import com.projet.scootop.domain.domainuser.Scoot;
import com.projet.scootop.domain.inprogress.StatisticalSheet;
import com.projet.scootop.domain.services.Events;
import com.projet.scootop.domain.services.Wearable;

public class MatchSheetDTO {
    public int id;
    public Events event;
    public List<Team> team;
    public List<StatisticalSheet> statisticalSheets;
    public Stade stade;
    public List <Scoot> matchScoots;
    public List<Wearable> wearables;
    public Saison saison;
    public Competition competitionType;

    public static MatchSheetDTO create(Events event, List<Team> team, List<StatisticalSheet> statisticalSheets, Stade stade, List<Scoot> matchScoots,List<Wearable> wearables, Saison saison, Competition competitionType) {
        MatchSheetDTO matchSheetDTO= new MatchSheetDTO();

        matchSheetDTO.event = event;

        //** Api Teams**//
        matchSheetDTO.team = team;

        //** Api StatisticalSheets**//
        matchSheetDTO.statisticalSheets = statisticalSheets;

        matchSheetDTO.stade = stade;

        //** Api Scoots**//
        matchSheetDTO.matchScoots = matchScoots;

        //** Api Wearables**//
        matchSheetDTO.wearables = wearables;
        matchSheetDTO.saison = saison;
        matchSheetDTO.competitionType = competitionType;
        return matchSheetDTO;
    }

}