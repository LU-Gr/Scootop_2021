package com.projet.scootop.functions;

import com.projet.scootop.domain.configuration.CompetitionType;
import com.projet.scootop.domain.tools.Saison;
import com.projet.scootop.domain.tools.StatisticalSheet;
import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.domain.user.domain.Player;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

// Stats d'un joueur selon le type de compétition
@ToString
public class UserResume {

    @Getter private List<StatisticalSheet> statisticalSheets;
    
    @Getter private int goals = 0;
    @Getter private int matchPlayed = 0;
    @Getter private int matchWon = 0;
    @Getter private int ballsPlayed = 0;
    @Getter private int ballsSuccess = 0;
    @Getter private int ballsLost = 0;
    @Getter private int actions = 0;
    @Getter private int actionsSuccess = 0;
    @Getter private int actionsFailed = 0;
    @Getter private int assists = 0;
    @Getter private int shoots = 0;
    @Getter private int shootsInBox = 0;
    @Getter private int shootsFailed = 0;
    @Getter private int passes = 0;
    @Getter private int passesSuccess = 0;
    @Getter private int passesFailed = 0;
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
        			.filter(s -> s.getMatch().getCompetition().getCompetitionType() == competitionType)
        			.collect(Collectors.toList());
        }

        countGoals();
        countPasses();
        countTraveledDistance();
        countMatchPlayed();
        countMatchWon();
        countBallPlayed();
        countBallSuccess();
        countBallLost();
        countActions();
        countActionsFailed();
        countActionsSuccess();
        countShootsInBox();
        countShootsFailed();
        countPassesSuccess();
        countPassesFailed();
        countAssists();
    }


	private void countAssists() {
		for (StatisticalSheet sheet: this.statisticalSheets) {
        	this.assists = this.assists + (int) sheet.getPasses()
        		.stream()
        		.filter(p -> p.getIsDecisive())
        		.count();
        }	
	}


	public void countGoals(){
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	this.goals = this.goals + sheet.getGoals().size();
        }
    }
    
    public void countPasses(){
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	this.passes = this.passes + sheet.getPasses().size();
        }
    }

    public void countPassesSuccess(){
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	this.passesSuccess = this.passesSuccess + (int) sheet.getPasses()
        		.stream()
        		.filter(p -> p.getIsSuccess() == true)
        		.count();
        }
    }
    
    public void countPassesFailed(){
    	for (StatisticalSheet sheet: this.statisticalSheets) {
    		this.passesFailed = this.passesFailed + (int) sheet.getPasses()
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
        	this.ballsPlayed = this.ballsSuccess + sheet.getNbBallplayed();
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
    
    private void countMatchWon() {
    	this.matchWon = (int) this.statisticalSheets.stream().filter(s -> s.getTeam() == s.getMatch().getWinner()).count();
	}
    
    public void countDribblesSuccess(){
    	for (StatisticalSheet sheet: this.statisticalSheets) {
        	this.dribblesSuccess = this.dribblesSuccess + (int) (sheet.getActions()
        			.stream()
        			.filter(a -> a.getActionType().getName() == "Dribble")
        			.filter(a -> a.getIsSuccessful() == true)
        			.count());
        }
    }
}
