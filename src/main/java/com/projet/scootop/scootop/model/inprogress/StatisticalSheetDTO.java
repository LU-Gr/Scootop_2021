package com.projet.scootop.scootop.model.inprogress;

import java.util.List;

import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.inprogess.MatchSheet;
import com.projet.scootop.scootop.domain.services.Events;
import com.projet.scootop.scootop.domain.stastistical.Pass;
import com.projet.scootop.scootop.domain.stastistical.Goal;
import com.projet.scootop.scootop.domain.stastistical.Shoot;
import com.projet.scootop.scootop.domain.stastistical.Action;
import com.projet.scootop.scootop.domain.stastistical.physical.PlayerHead;

public class StatisticalSheetDTO {
    public Long id;
    public MatchSheet matchSheet;
    public List<Player> players;
    public Events events;
    public int ShootIn;
    public int ShootOut;
    public int ballplayed;
    public int balllost;
    public int ballSuccess;
    public List<Shoot> Shoots;
    public List<PlayerHead> Heads;
    public List<Pass> assists;
    public List<Action> skills;
    public List<Goal> goals;

    public float distancekm;


    public static StatisticalSheetDTO create(MatchSheet matchSheet, List<Player> players, Events events, int shootIn, int shootOut, int ballplayed,int balllost,int ballSuccess, List<Shoot> shoots, List<PlayerHead> heads, List<Pass> assists, List<Action> skills, List<Goal> goals, float distancekm) {
        StatisticalSheetDTO statisticalSheetDTO= new StatisticalSheetDTO();
        statisticalSheetDTO.matchSheet = matchSheet;
        statisticalSheetDTO.players =players;
        statisticalSheetDTO.events = events;
        statisticalSheetDTO.ShootIn = shootIn;
        statisticalSheetDTO.ShootOut = shootOut;
        statisticalSheetDTO.ballplayed = ballplayed;
        statisticalSheetDTO.balllost = balllost;
        statisticalSheetDTO.ballSuccess = ballSuccess;
        statisticalSheetDTO.Shoots = shoots;
        statisticalSheetDTO.Heads = heads;
        statisticalSheetDTO.assists = assists;
        statisticalSheetDTO.skills = skills;
        statisticalSheetDTO.goals = goals;
        statisticalSheetDTO.distancekm = distancekm;
        return statisticalSheetDTO;
    }

    public static StatisticalSheetDTO get(Long id, MatchSheet matchSheet, List<Player> players, Events events, int shootIn, int shootOut, int ballplayed,int balllost,int ballSuccess, List<Shoot> shoots, List<PlayerHead> heads, List<Pass> assists, List<Action> skills, List<Goal> goals, float distancekm) {
        StatisticalSheetDTO statisticalSheetDTO= new StatisticalSheetDTO();
        statisticalSheetDTO.id =id;
        statisticalSheetDTO.matchSheet = matchSheet;
        statisticalSheetDTO.players = players;
        statisticalSheetDTO.events = events;
        statisticalSheetDTO.ShootIn = shootIn;
        statisticalSheetDTO.ShootOut = shootOut;
        statisticalSheetDTO.ballplayed = ballplayed;
        statisticalSheetDTO.balllost = balllost;
        statisticalSheetDTO.ballSuccess = ballSuccess;
        statisticalSheetDTO.Shoots = shoots;
        statisticalSheetDTO.Heads = heads;
        statisticalSheetDTO.assists = assists;
        statisticalSheetDTO.skills = skills;
        statisticalSheetDTO.goals = goals;
        statisticalSheetDTO.distancekm = distancekm;
        return statisticalSheetDTO;
    }
}
