package com.projet.scootop.scootop.model.inprogress;

import java.util.List;

import com.projet.scootop.scootop.domain.domainconfiguration.Stadium;
import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.domaintools.CompetitionType;
import com.projet.scootop.scootop.domain.domaintools.Saison;
import com.projet.scootop.scootop.domain.domainuser.Scoot;
import com.projet.scootop.scootop.domain.inprogess.StatisticalSheet;
import com.projet.scootop.scootop.domain.services.Events;
import com.projet.scootop.scootop.domain.services.Wearable;

public class MatchSheetDTO {
    public int id;
    public Events event;
    public List<Team> team;
    public List<StatisticalSheet> statisticalSheets;
    public Stadium stade;
    public List <Scoot> matchScoots;
    public List<Wearable> wearables;
    public Saison saison;
    public CompetitionType competitionType;

    public static MatchSheetDTO create(Events event, List<Team> team, List<StatisticalSheet> statisticalSheets, Stadium stade, List<Scoot> matchScoots,List<Wearable> wearables, Saison saison, CompetitionType competitionType) {
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
