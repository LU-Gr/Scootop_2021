package com.projet.scootop.domain.services;

import com.projet.scootop.domain.domainconfiguration.CompetitionType;
import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.domaintools.Saison;
import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.inprogress.StatisticalSheet;
import lombok.Getter;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

// Stats d'un joueur selon le type de compétition
public class UserResume {

    private List<StatisticalSheet> statisticalSheets;
    
    @Getter private int goals = 0;
    @Getter private int matchPlayed = 0;
    @Getter private int ballsPlayed = 0;
    @Getter private int ballsSuccess = 0;
    @Getter private int ballsLost = 0;
    @Getter private int actions = 0;
    @Getter private int actionsSuccess = 0;
    @Getter private int actionsFailed = 0;
    @Getter private int shoots = 0;
    @Getter private int shootsInBox = 0;
    @Getter private int shootsFailed = 0;
    @Getter private int assists = 0;
    @Getter private int assistsSuccess = 0;
    @Getter private int assistsFailed = 0;
    @Getter private Float traveledDistance = 0f;
	@Getter private int dribblesSuccess;
    

    public UserResume(Player player, CompetitionType competitionType, Saison saison, Team team) { 
        this.statisticalSheets = player.getStatisticalSheets();
        if(team != null) {
        	this.statisticalSheets = this.statisticalSheets
        			.stream()
        			.filter(s -> s.getTeam() == team)
        			.collect(Collectors.toList());
        }
        if(saison != null) {
        	this.statisticalSheets = this.statisticalSheets
        			.stream()
        			.filter(s -> s.getEvent().getDate().isAfter(saison.getDateDebut()))
        			.filter(s -> s.getEvent().getDate().isBefore(saison.getDateFin()))
        			.collect(Collectors.toList());
        }
        if(competitionType != null) {
        	this.statisticalSheets = this.statisticalSheets
        			.stream()
        			.filter(s -> s.getMatchSheet().getCompetition().getCompetitionType() == competitionType)
        			.collect(Collectors.toList());
        }

        countGoals();
        countAssits();
        countTraveledDistance();
        countMatchPlayed();
        countBallPlayed();
        countBallSuccess();
        countBallLost();
        countActions();
        countActionsFailed();
        countActionsSuccess();
        countShootsInBox();
        countShootsFailed();
        countAssistsSuccess();
        countAssistsFailed();
    }


    public void countGoals(){
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	this.goals = this.goals + sheet.getGoals().size();
        }
    }
    
    public void countAssits(){
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	this.assists = this.assists + sheet.getPasses().size();
        }
    }

    public void countAssistsSuccess(){
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	this.assistsSuccess = this.assistsSuccess + (int) sheet.getPasses()
        		.stream()
        		.filter(p -> p.getIsSuccess() == true)
        		.count();
        }
    }
    
    public void countAssistsFailed(){
    	for (StatisticalSheet sheet: this.statisticalSheets) {
    		this.assistsFailed = this.assistsFailed + (int) sheet.getPasses()
        		.stream()
        		.filter(p -> p.getIsSuccess() == true)
        		.count();
        }
    }

    public void countTraveledDistance(){
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	this.traveledDistance = traveledDistance + sheet.getDistancekm();
        }
    }
    public void countBallPlayed(){
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	this.ballsSuccess = this.ballsSuccess + sheet.getNbBallplayed();
        }
    }

    public void countShoots(LocalDate Years, Player player){
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	this.shoots = this.shoots + sheet.getShoots().size();
        }
    }

    public void countShootsInBox(){
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	this.shootsInBox = this.shootsInBox + (int) sheet.getShoots()
        		.stream()
        		.filter(s -> s.getIsInBox() == true)
        		.count();
        }
    }
    
    public void countShootsFailed(){
    	for (StatisticalSheet sheet: this.statisticalSheets) {
        	this.shootsFailed = this.shootsFailed + (int) (sheet.getShoots()
        		.stream()
        		.filter(s -> s.getIsInBox() == false)
        		.count());
        }
    }

    public void countBallLost(){
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	this.ballsLost = this.ballsLost + sheet.getNbBalllost();
        }
    }
    
    public void countBallSuccess(){
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	this.ballsSuccess = this.ballsSuccess + sheet.getNbBallSuccess();
        }
    }

    public void countActionsSuccess(){
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	this.actionsSuccess = this.actionsSuccess + (int) (sheet.getActions()
        			.stream()
        			.filter(a -> a.getIsSuccessful() == true)
        			.count());
        }
    }
    
    public void countActionsFailed(){
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	this.actionsFailed = this.actionsFailed + (int) (sheet.getActions()
        			.stream()
        			.filter(a -> a.getIsSuccessful() == false)
        			.count());
        }
    }
    
    public void countActions(){
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	this.actions = this.actions + sheet.getActions().size();
        }
    }

    public void countMatchPlayed(){
        this.matchPlayed = this.statisticalSheets.size();
    }
    
    public void countDribblesSuccess(){
    	for (StatisticalSheet sheet: this.statisticalSheets) {
        	this.dribblesSuccess = this.dribblesSuccess + (int) (sheet.getActions()
        			.stream()
        			.filter(a -> a.getSkill().getName() == "Dribble")
        			.filter(a -> a.getIsSuccessful() == true)
        			.count());
        }
    }
}
