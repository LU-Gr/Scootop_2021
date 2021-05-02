package com.projet.scootop.domain.services;

import javax.persistence.*;

import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.domaintools.Competition;
import com.projet.scootop.domain.domaintools.Saison;
import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.inprogress.StatisticalSheet;
import com.projet.scootop.domain.statistical.Goal;
import com.projet.scootop.domain.statistical.Pass;
import com.projet.scootop.domain.statistical.Shoot;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Stats d'un joueur selon le type de compétition
@Entity
@ToString
@Table(name = "UserResume")
public class UserResume {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @OneToOne
    @Getter @Setter
    private Player player;
    
    @OneToOne
    @Getter @Setter
    private Competition competitionType;
    
    @OneToMany
    @Getter @Setter
    private List<StatisticalSheet> statisticalSheets;

    @OneToMany
    @Getter @Setter
    private List<Saison> saisons;

    public UserResume(Long id, Player player, Competition competitionType, List<Goal> goals, List<Pass> assists,List <StatisticalSheet> statisticalSheet, float distance_traveled, List<Team> teams, List<Saison> saisons, int ballPlayed, int ballLost, int defensiveSkills, int offensiveSkills) {
        this.id = id;
        this.player = player;
        this.competitionType = competitionType;
        this.statisticalSheets = statisticalSheet;
        this.saisons = saisons;
    }

    public UserResume() {
    }

    public void GenerateSaison(Saison saison, Competition competitionType, Team team){

        for (int i = 0; i < saisons.size() ; i++) {


            Team playerTeam = team;

            LocalDate startSaison = saisons.get(i).getDateDebut();
            List<Goal> SaisonsGoals = null;
            List<Pass> SaisonsAssists = null;

            CountYearsGoals(startSaison, this.player);
            CountYearsAssits(startSaison, this.player);
            CountYearsTraveledDistance(startSaison,this.player);
            CountGamePlayed(startSaison,this.player);
            CountBallPlayed(startSaison,this.player);
            CountBallLost(startSaison,this.player);
            CountBallSuccess(startSaison,this.player);
            CountSkillsYears(startSaison,this.player);
            CountSkillsSuccess(startSaison,this.player);
            CountSkillsFailed(startSaison,this.player);
            CountShootsYears(startSaison,this.player);
            CountShootsSuccessYears(startSaison,this.player);
            CountShootsFailedYears(startSaison,this.player);
            CountYearsSuccessAssists(startSaison,this.player);
            CountYearsFailedAssists(startSaison,this.player);

            int yearsGoals = CountYearsGoals(startSaison, this.player);
            int yearsAssists = CountYearsAssits(startSaison, this.player);
            Float distance_traveled = CountYearsTraveledDistance(startSaison,this.player);
            int game_played_years = CountGamePlayed(startSaison,this.player);
            int ball_played_years = CountBallPlayed(startSaison,this.player);
            int ball_Success_years = CountBallSuccess(startSaison,this.player);
            int ball_lost_years = CountBallLost(startSaison,this.player);
            int Skills_years = CountSkillsYears(startSaison,this.player);
            int Skills_Success_years = CountSkillsSuccess(startSaison,this.player);
            int Skills_Failed_years = CountSkillsFailed(startSaison,this.player);
            int Count_Shoot_years = CountSkillsSuccess(startSaison,this.player);
            int Count_Shoot_Success = CountShootsSuccessYears(startSaison,this.player);
            int Count_Shoot_Failed = CountShootsFailedYears(startSaison,this.player);
            int Count_Assists_Success = CountYearsSuccessAssists(startSaison,this.player);
            int Count_Assists_Failed = CountYearsFailedAssists(startSaison,this.player);

        }
    }

    public int CountYearsGoals(LocalDate Years, Player Player){

        LocalDate startSaison = Years;
        LocalDate endSaison = startSaison.plusMonths(8);

        List<Goal> SaisonsGoals = new ArrayList<>();
        int GoalsCountYears = 0;

        for (StatisticalSheet statisticalSheet: this.statisticalSheets) {
        	for(Goal goal: statisticalSheet.getGoals()) {
        		LocalDate goalDate = goal.getDate();
        		if(goalDate.isAfter(startSaison) && goalDate.isBefore(endSaison)) {
        			SaisonsGoals.add(goal);
        		}
        	}
        }
        
        GoalsCountYears = SaisonsGoals.size();
        return GoalsCountYears;
    }
    public int CountYearsAssits(LocalDate Years, Player player){

    	LocalDate startSaison = Years;
        LocalDate endSaison = startSaison.plusMonths(8);

        List<Pass> SaisonsAssists = new ArrayList<>();
        int AssistsCountYears = 0;

        for (StatisticalSheet statisticalSheet: this.statisticalSheets) {
        	for(Pass pass: statisticalSheet.getPasses()) {
        		LocalDate passDate = pass.getDate();
        		if(passDate.isAfter(startSaison) && passDate.isBefore(endSaison)) {
        			SaisonsAssists.add(pass);
        		}
        	}
        }
        AssistsCountYears = SaisonsAssists.size();
        return AssistsCountYears;
    }

    public int CountYearsSuccessAssists(LocalDate Years, Player player){

    	LocalDate startSaison = Years;
        LocalDate endSaison = startSaison.plusMonths(8);

        List<Pass> SaisonsSuccessAssistsList = new ArrayList<>();
        int SuccessAssistsCountYears = 0;
        
        for (StatisticalSheet statisticalSheet: this.statisticalSheets) {
        	for(Pass pass: statisticalSheet.getPasses()) {
        		LocalDate passDate = pass.getDate();
        		if(passDate.isAfter(startSaison) && passDate.isBefore(endSaison) && pass.getIsSuccess()) {
        			SaisonsSuccessAssistsList.add(pass);
        		}
        	}
        }

        SuccessAssistsCountYears =  SaisonsSuccessAssistsList.size();
        return SuccessAssistsCountYears;
    }
    
    public int CountYearsFailedAssists(LocalDate Years, Player player){

    	LocalDate startSaison = Years;
        LocalDate endSaison = startSaison.plusMonths(8);

        List<Pass> SaisonsSuccessAssistsList = new ArrayList<>();
        int FailedAssistsCountYears = 0;
        
        for (StatisticalSheet statisticalSheet: this.statisticalSheets) {
        	for(Pass pass: statisticalSheet.getPasses()) {
        		LocalDate passDate = pass.getDate();
        		if(passDate.isAfter(startSaison) && passDate.isBefore(endSaison) && !pass.getIsSuccess()) {
        			SaisonsSuccessAssistsList.add(pass);
        		}
        	}
        }

        FailedAssistsCountYears =  SaisonsSuccessAssistsList.size();
        return FailedAssistsCountYears;
    }

    public Float CountYearsTraveledDistance(LocalDate Years, Player player){

        LocalDate startSaison = Years;
        LocalDate endSaison = startSaison.plusMonths(8);
        Float traveledDistanceYears = 0f;
        
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	LocalDate eventDate = sheet.getEvent().getDate();
        	if(eventDate.isAfter(startSaison) && eventDate.isBefore(endSaison)){
        		traveledDistanceYears = traveledDistanceYears + sheet.getDistancekm();
        	}
        }

        return traveledDistanceYears;
    }
    public Integer CountBallPlayed(LocalDate Years, Player player){

        LocalDate startSaison = Years;
        LocalDate endSaison = startSaison.plusMonths(8);
        int SaisonBallSuccess = 0;
        
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	LocalDate eventDate = sheet.getEvent().getDate();
        	if(eventDate.isAfter(startSaison) && eventDate.isBefore(endSaison)){
        		SaisonBallSuccess = SaisonBallSuccess + sheet.getNbBallplayed();
        	}
        }

        return SaisonBallSuccess;
    }

    public Integer CountShootsYears(LocalDate Years, Player player){

        LocalDate startSaison = Years;
        LocalDate endSaison = startSaison.plusMonths(8);
        int SaisonShoots = 0;
        
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	LocalDate eventDate = sheet.getEvent().getDate();
        	if(eventDate.isAfter(startSaison) && eventDate.isBefore(endSaison)){
                SaisonShoots = SaisonShoots + sheet.getShoots().size();
        	}
        }
        return SaisonShoots;
    }

    public Integer CountShootsSuccessYears(LocalDate Years, Player player){

    	LocalDate startSaison = Years;
        LocalDate endSaison = startSaison.plusMonths(8);
        int goals = 0;
        
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	LocalDate eventDate = sheet.getEvent().getDate();
        	if(eventDate.isAfter(startSaison) && eventDate.isBefore(endSaison)){
        		for(Shoot shoot: sheet.getShoots()) {
        			if(shoot.getIsGoal()) {
        				goals++;
        			}
        		}
        	}
        }
        return goals;
    }
    
    public Integer CountShootsFailedYears(LocalDate Years, Player player){
    	
    	LocalDate startSaison = Years;
        LocalDate endSaison = startSaison.plusMonths(8);
        int goals = 0;
        
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	LocalDate eventDate = sheet.getEvent().getDate();
        	if(eventDate.isAfter(startSaison) && eventDate.isBefore(endSaison)){
        		for(Shoot shoot: sheet.getShoots()) {
        			if(!shoot.getIsGoal()) {
        				goals++;
        			}
        		}
        	}
        }
        return goals;
    }

    public Integer CountBallLost(LocalDate Years, Player player){

        LocalDate startSaison = Years;
        LocalDate endSaison = startSaison.plusMonths(8);
        int SaisonBallLost = 0;
        
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	LocalDate eventDate = sheet.getEvent().getDate();
        	if(eventDate.isAfter(startSaison) && eventDate.isBefore(endSaison)){
        		SaisonBallLost = SaisonBallLost + sheet.getNbBalllost();
        	}
        }

        return SaisonBallLost;
    }
    
    public Integer CountBallSuccess(LocalDate Years, Player player){

        LocalDate startSaison = Years;
        LocalDate endSaison = startSaison.plusMonths(8);
        int SaisonBallSuccess = 0;
        
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	LocalDate eventDate = sheet.getEvent().getDate();
        	if(eventDate.isAfter(startSaison) && eventDate.isBefore(endSaison)){
        		SaisonBallSuccess = SaisonBallSuccess + sheet.getNbBallSuccess();
        	}
        }

        return SaisonBallSuccess;
    }

    public Integer CountSkillsSuccess(LocalDate Years, Player player){


        LocalDate startSaison = Years;
        LocalDate endSaison = startSaison.plusMonths(8);
        int SaisonSkillsSuccess = 0;
        
        for (StatisticalSheet sheet: this.statisticalSheets) {
        	LocalDate eventDate = sheet.getEvent().getDate();
        	if(eventDate.isAfter(startSaison) && eventDate.isBefore(endSaison)){
        		SaisonSkillsSuccess = SaisonSkillsSuccess + (int) (sheet.getActions().stream().filter(a -> a.getIsSuccessful() == true).count());
        	}
        }

        return SaisonSkillsSuccess;
    }
    
    public Integer CountSkillsFailed(LocalDate Years, Player player){

        LocalDate startSaison = Years;
        LocalDate endSaison = startSaison.plusMonths(8);
        int SaisonSkillsFailed = 0;

        for (StatisticalSheet sheet: this.statisticalSheets) {
        	LocalDate eventDate = sheet.getEvent().getDate();
        	if(eventDate.isAfter(startSaison) && eventDate.isBefore(endSaison)){
        		SaisonSkillsFailed = SaisonSkillsFailed + (int) (sheet.getActions().stream().filter(a -> a.getIsSuccessful() == false).count());
        	}
        }

        return SaisonSkillsFailed;
    }
    public Integer CountSkillsYears(LocalDate Years, Player player){


        LocalDate startSaison = Years;
        LocalDate endSaison = startSaison.plusMonths(8);
        int SaisonSkills = 0;

        for (StatisticalSheet sheet: this.statisticalSheets) {
        	LocalDate eventDate = sheet.getEvent().getDate();
        	if(eventDate.isAfter(startSaison) && eventDate.isBefore(endSaison)){
        		SaisonSkills = SaisonSkills + sheet.getActions().size();
        	}
        }
        
        return SaisonSkills;
    }

    public Integer CountGamePlayed(LocalDate Years, Player player){
    	
        LocalDate startSaison = Years;
        LocalDate endSaison = startSaison.plusMonths(8);
        return this.statisticalSheets.stream().filter(s -> s.getEvent().getDate().isAfter(startSaison)).filter(s -> s.getEvent().getDate().isBefore(endSaison)).collect(Collectors.toList()).size();
    }
}
