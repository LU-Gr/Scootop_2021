package com.projet.scootop.scootop.domain.services;

import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.domaintools.Competition;
import com.projet.scootop.scootop.domain.domaintools.Saison;
import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.inprogess.StatisticalSheet;
import com.projet.scootop.scootop.domain.stastistical.Pass;
import com.projet.scootop.scootop.domain.stastistical.Goal;
import com.projet.scootop.scootop.domain.stastistical.Action;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Stats d'un joueur selon le type de compétition
@Entity
@Table(name = "UserResume")
public class UserResume {

    public UserResume(Player player, Competition competitionType, List<StatisticalSheet> statisticalSheets, List<Team> teams, List<Saison> saisons, int defensiveSkills, int offensiveSkills) {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToOne
    public Player player;
    
    @OneToOne
    public Competition competitionType;
    
    @OneToMany
    public List<StatisticalSheet> statisticalSheets;

    //TODO: remplacer par filter player.teams.competitionType == competitonType
    @OneToMany
    public List<Team> teams;

    @OneToMany
    public List<Saison> saisons;

    // dans statisticalSheets
    public int defensiveSkills;
    public int OffensiveSkills;

    public UserResume(Long id, Player player, Competition competitionType, List<Goal> goals, List<Pass> assists,List <StatisticalSheet> statisticalSheet, float distance_traveled, List<Team> teams, List<Saison> saisons, int ballPlayed, int ballLost, int defensiveSkills, int offensiveSkills) {
        this.id = id;
        this.player = player;
        this.competitionType = competitionType;
        this.statisticalSheets = statisticalSheet;
        this.teams = teams;
        this.saisons = saisons;
        this.defensiveSkills = defensiveSkills;
        this.OffensiveSkills = offensiveSkills;
    }

    @Override
    public String toString() {
        return "UserResume{" +
                "id=" + id +
                ", player=" + player +
                ", competitionType=" + competitionType +
                ", statisticalSheets=" + statisticalSheets +
                ", teams=" + teams +
                ", saisons=" + saisons +
                ", defensiveSkills=" + defensiveSkills +
                ", OffensiveSkills=" + OffensiveSkills +
                '}';
    }

    public UserResume() {
    }

    public void GenerateSaison(Saison saison, Competition competitionType, Team team){

        for (int i = 0; i < saisons.size() ; i++) {


            Team playerTeam = team;

            LocalDate StartSaision = saisons.get(i).getDateDebut();
            List<Goal> SaisonsGoals = null;
            List<Pass> SaisonsAssists = null;

            CountYearsGoals(StartSaision, this.player);
            CountYearsAssits(StartSaision, this.player);
            CountYearsTraveledDistance(StartSaision,this.player);
            CountGamePlayed(StartSaision,this.player);
            CountBallPlayed(StartSaision,this.player);
            CountBallLost(StartSaision,this.player);
            CountBallSuccess(StartSaision,this.player);
            CountSkillsYears(StartSaision,this.player);
            CountSkillsSuccess(StartSaision,this.player);
            CountSkillsFailed(StartSaision,this.player);
            CountShootsYears(StartSaision,this.player);
            CountShootsSuccessYears(StartSaision,this.player);
            CountShootsFailedYears(StartSaision,this.player);
            CountYearsSuccessAssists(StartSaision,this.player);
            CountYearsFailedAssists(StartSaision,this.player);

            int yearsGoals = CountYearsGoals(StartSaision, this.player);
            int yearsAssists = CountYearsAssits(StartSaision, this.player);
            Float distance_traveled = CountYearsTraveledDistance(StartSaision,this.player);
            int game_played_years = CountGamePlayed(StartSaision,this.player);
            int ball_played_years = CountBallPlayed(StartSaision,this.player);
            int ball_Success_years = CountBallSuccess(StartSaision,this.player);
            int ball_lost_years = CountBallLost(StartSaision,this.player);
            int Skills_years = CountSkillsYears(StartSaision,this.player);
            int Skills_Success_years = CountSkillsSuccess(StartSaision,this.player);
            int Skills_Failed_years = CountSkillsFailed(StartSaision,this.player);
            int Count_Shoot_years = CountSkillsSuccess(StartSaision,this.player);
            int Count_Shoot_Success = CountShootsSuccessYears(StartSaision,this.player);
            int Count_Shoot_Failed = CountShootsFailedYears(StartSaision,this.player);
            int Count_Assists_Success = CountYearsSuccessAssists(StartSaision,this.player);
            int Count_Assists_Failed = CountYearsFailedAssists(StartSaision,this.player);

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
        		if(passDate.isAfter(startSaison) && passDate.isBefore(endSaison) && pass.isSuccess) {
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
        		if(passDate.isAfter(startSaison) && passDate.isBefore(endSaison) && !pass.isSuccess) {
        			SaisonsSuccessAssistsList.add(pass);
        		}
        	}
        }

        FailedAssistsCountYears =  SaisonsSuccessAssistsList.size();
        return FailedAssistsCountYears;
    }

    public Float CountYearsTraveledDistance(LocalDate Years, Player player){


        LocalDate StartSaision = Years;
        LocalDate EndSaision = StartSaision.plusMonths(8);

        List<Float> SaisonsDistancesTraveled = null;
        List<StatisticalSheet> SaisonsMatchPlayed = null;
        Float TraveledDistanceYears = null;

        for (int j = 0; j < SaisonsMatchPlayed.size() ; j++) {

            if(statisticalSheets.get(j).getEvents().date.isBefore(EndSaision) && statisticalSheets.get(j).getEvents().date.isAfter(StartSaision)){

                SaisonsDistancesTraveled.add(SaisonsMatchPlayed.get(j).getDistancekm());
                TraveledDistanceYears = TraveledDistanceYears + SaisonsDistancesTraveled.get(j);
            }

            //SaisonsMatchPlayed.get(j).getDistancekm();
        }


        return TraveledDistanceYears;
    }
    public Integer CountBallPlayed(LocalDate Years, Player player){


        LocalDate StartSaision = Years;
        LocalDate EndSaision = StartSaision.plusMonths(8);

        List<Integer> SaisonsBallPlayed = null;
        List<StatisticalSheet> SaisonsMatchPlayed = null;
        int SaisonBallSuccess = 0;

        for (int j = 0; j < SaisonsMatchPlayed.size() ; j++) {

            if(statisticalSheets.get(j).getEvents().date.isBefore(EndSaision) && statisticalSheets.get(j).getEvents().date.isAfter(StartSaision)){

                SaisonsBallPlayed.add(SaisonsMatchPlayed.get(j).getBallplayed());
                SaisonBallSuccess = SaisonBallSuccess + SaisonsBallPlayed.get(j);
            }

            //SaisonsMatchPlayed.get(j).getDistancekm();
        }


        return SaisonBallSuccess;
    }

    public Integer CountShootsYears(LocalDate Years, Player player){


        LocalDate StartSaision = Years;
        LocalDate EndSaision = StartSaision.plusMonths(8);

        List<Integer> SaisonsShoots = null;
        List<StatisticalSheet> SaisonsMatchPlayed = null;
        int SaisonShoots = 0;

        for (int j = 0; j < SaisonsMatchPlayed.size() ; j++) {

            if(statisticalSheets.get(j).getEvents().date.isBefore(EndSaision) && statisticalSheets.get(j).getEvents().date.isAfter(StartSaision)){

                for (int i = 0; i < statisticalSheets.get(j).getPlayers().size(); i++) {

                    if(statisticalSheets.get(j).getPlayers().get(i).id == player.id) {

                        SaisonsShoots.add(SaisonsMatchPlayed.get(j).getShoots().size());
                        SaisonShoots = SaisonShoots + SaisonsShoots.get(j);

                    }

                }
            }
        }


        return SaisonShoots;
    }

    public Integer CountShootsSuccessYears(LocalDate Years, Player player){


        LocalDate StartSaision = Years;
        LocalDate EndSaision = StartSaision.plusMonths(8);

        List<Integer> SaisonsShootsSuccessList = null;
        List<StatisticalSheet> SaisonsMatchPlayed = null;
        int SaisonShootsSuccess = 0;

        for (int j = 0; j < SaisonsMatchPlayed.size() ; j++) {

            if(statisticalSheets.get(j).getEvents().date.isBefore(EndSaision) && statisticalSheets.get(j).getEvents().date.isAfter(StartSaision)){

                for (int i = 0; i < statisticalSheets.get(j).getPlayers().size(); i++) {

                    if(statisticalSheets.get(j).getPlayers().get(i).id == player.id) {

                        SaisonsShootsSuccessList.add(SaisonsMatchPlayed.get(j).getShootIn());
                        SaisonShootsSuccess = SaisonShootsSuccess + SaisonsShootsSuccessList.get(j);

                    }

                }
            }
        }


        return SaisonShootsSuccess;
    }
    public Integer CountShootsFailedYears(LocalDate Years, Player player){


        LocalDate StartSaision = Years;
        LocalDate EndSaision = StartSaision.plusMonths(8);

        List<Integer> SaisonsShootsFailedList = null;
        List<StatisticalSheet> SaisonsMatchPlayed = null;
        int SaisonShootsFailed = 0;

        for (int j = 0; j < SaisonsMatchPlayed.size() ; j++) {

            if(statisticalSheets.get(j).getEvents().date.isBefore(EndSaision) && statisticalSheets.get(j).getEvents().date.isAfter(StartSaision)){

                for (int i = 0; i < statisticalSheets.get(j).getPlayers().size(); i++) {

                    if(statisticalSheets.get(j).getPlayers().get(i).id == player.id) {

                        SaisonsShootsFailedList.add(SaisonsMatchPlayed.get(j).getShootOut());
                        SaisonShootsFailed = SaisonShootsFailed + SaisonsShootsFailedList.get(j);

                    }

                }
            }
        }


        return SaisonShootsFailed;
    }

    public Integer CountBallLost(LocalDate Years, Player player){


        LocalDate StartSaision = Years;
        LocalDate EndSaision = StartSaision.plusMonths(8);

        List<Integer> SaisonsBallLosts = null;
        List<StatisticalSheet> SaisonsMatchPlayed = null;
        int SaisonBallLost = 0;

        for (int j = 0; j < SaisonsMatchPlayed.size() ; j++) {

            if(statisticalSheets.get(j).getEvents().date.isBefore(EndSaision) && statisticalSheets.get(j).getEvents().date.isAfter(StartSaision)){

                SaisonsBallLosts.add(SaisonsMatchPlayed.get(j).getBalllost());
                SaisonBallLost = SaisonBallLost + SaisonsBallLosts.get(j);
            }

        }


        return SaisonBallLost;
    }
    public Integer CountBallSuccess(LocalDate Years, Player player){


        LocalDate StartSaision = Years;
        LocalDate EndSaision = StartSaision.plusMonths(8);

        List<Integer> SaisonsBallSuccessList = null;
        List<StatisticalSheet> SaisonsMatchPlayed = null;
        int SaisonBallSuccess = 0;

        for (int j = 0; j < SaisonsMatchPlayed.size() ; j++) {

            if(statisticalSheets.get(j).getEvents().date.isBefore(EndSaision) && statisticalSheets.get(j).getEvents().date.isAfter(StartSaision)){

                SaisonsBallSuccessList.add(SaisonsMatchPlayed.get(j).getBallSuccess());
                SaisonBallSuccess = SaisonBallSuccess + SaisonsBallSuccessList.get(j);
            }

        }


        return SaisonBallSuccess;
    }

    public Integer CountSkillsSuccess(LocalDate Years, Player player){


        LocalDate StartSaision = Years;
        LocalDate EndSaision = StartSaision.plusMonths(8);

        List<Action> SaisonsSkillsSuccessList = null;
        List<StatisticalSheet> SaisonsMatchPlayed = null;
        int SaisonSkillsSuccess = 0;

        for (int j = 0; j < SaisonsMatchPlayed.size() ; j++) {

            if(statisticalSheets.get(j).getEvents().date.isBefore(EndSaision) && statisticalSheets.get(j).getEvents().date.isAfter(StartSaision)){

                if(SaisonsMatchPlayed.get(j).getSkills().get(j).getSuccessSkill() == true){

                SaisonsSkillsSuccessList.add(SaisonsMatchPlayed.get(j).getSkills().get(j));
                SaisonSkillsSuccess = SaisonSkillsSuccess + SaisonsSkillsSuccessList.size();
                }
            }

        }


        return SaisonSkillsSuccess;
    }
    public Integer CountSkillsFailed(LocalDate Years, Player player){


        LocalDate StartSaision = Years;
        LocalDate EndSaision = StartSaision.plusMonths(8);

        List<Action> SaisonsSkillsFailedList = null;
        List<StatisticalSheet> SaisonsMatchPlayed = null;
        int SaisonSkillsFailed = 0;

        for (int j = 0; j < SaisonsMatchPlayed.size() ; j++) {

            if(statisticalSheets.get(j).getEvents().date.isBefore(EndSaision) && statisticalSheets.get(j).getEvents().date.isAfter(StartSaision)){

                if(SaisonsMatchPlayed.get(j).getSkills().get(j).getSuccessSkill() == false){

                SaisonsSkillsFailedList.add(SaisonsMatchPlayed.get(j).getSkills().get(j));
                SaisonSkillsFailed = SaisonSkillsFailed + SaisonsSkillsFailedList.size();
                }
            }

        }


        return SaisonSkillsFailed;
    }
    public Integer CountSkillsYears(LocalDate Years, Player player){


        LocalDate StartSaision = Years;
        LocalDate EndSaision = StartSaision.plusMonths(8);

        List<Action> SaisonsSkillsList = null;
        List<StatisticalSheet> SaisonsMatchPlayed = null;
        int SaisonSkills = 0;

        for (int j = 0; j < SaisonsMatchPlayed.size() ; j++) {

            if(statisticalSheets.get(j).getEvents().date.isBefore(EndSaision) && statisticalSheets.get(j).getEvents().date.isAfter(StartSaision)){


                SaisonsSkillsList.add(SaisonsMatchPlayed.get(j).getSkills().get(j));
                SaisonSkills = SaisonSkills + SaisonsSkillsList.size();

            }

        }


        return SaisonSkills;
    }

    public Integer CountGamePlayed(LocalDate Years, Player player){
        LocalDate StartSaision = Years;
        LocalDate EndSaision = StartSaision.plusMonths(8);

        List<StatisticalSheet> SaisonsMatchPlayed = null;
        int GamePlayedYears = 0;

        for (int j = 0; j < SaisonsMatchPlayed.size() ; j++) {

            if(statisticalSheets.get(j).getEvents().date.isBefore(EndSaision) && statisticalSheets.get(j).getEvents().date.isAfter(StartSaision)){

                SaisonsMatchPlayed.add(SaisonsMatchPlayed.get(j));
                GamePlayedYears = SaisonsMatchPlayed.size();
            }

        }
        return GamePlayedYears;
    }
}
