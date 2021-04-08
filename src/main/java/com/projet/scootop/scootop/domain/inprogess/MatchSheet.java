package com.projet.scootop.scootop.domain.inprogess;

import javax.persistence.*;

import com.projet.scootop.scootop.domain.domainconfiguration.Stade;
import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.domaintools.Competition;
import com.projet.scootop.scootop.domain.domaintools.Saison;
import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.domainuser.Scoot;
import com.projet.scootop.scootop.domain.services.Events;
import com.projet.scootop.scootop.domain.services.Wearable;

import java.util.ArrayList;
import java.util.List;

// Feuille de match
@Entity
@Table(name = "MatchSheet")
//TODO: Renommer en match
public class MatchSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToOne
    public Events event;
    
    //TODO: Remplacer en mettant 2 Team
    @OneToMany
    @JoinColumn(name="Match_Sheet_teams",referencedColumnName = "id")
    public List<Team> team;

    @OneToMany
    @JoinColumn(name="Match_Sheet_statistical",referencedColumnName = "id")
    public List<StatisticalSheet> statisticalSheets;
    @OneToOne
    public Stade stade;
    @ManyToMany
    @JoinColumn(name="Match_Sheet_scoot",referencedColumnName = "id")
    public List <Scoot> matchScoots;

    @OneToMany
    @JoinColumn(name="Match_Sheet_wearable",referencedColumnName = "id")
    public List<Wearable> wearables;

    @ManyToOne
    @JoinColumn(name = "SAISON_ID")
    public Saison saison;

    @OneToOne
    public Competition competitionType;

    public MatchSheet(Events event, List<Team> team, List<StatisticalSheet> statisticalSheets, Stade stade, List<Scoot> matchScoots, List<Wearable> wearables, Saison saison, Competition competitionType) throws Exception {
        this.event = event;
        this.competitionType = competitionType;
        this.statisticalSheets = statisticalSheets;
        this.stade = stade;
        this.matchScoots = matchScoots;
        this.saison = saison;
        this.wearables = wearables;
        if (team.size() == 2) {

            this.team = team;

            List<Player>  playersTeamA = this.team.get(1).getPlayers();
            List<Player>  playersTeamB = this.team.get(2).getPlayers();
            StatisticalSheet statisticalSheetsTeamA = new StatisticalSheet();
            StatisticalSheet statisticalSheetsTeamB = new StatisticalSheet();
            StatisticalSheet statisticalSheetsGame =  new StatisticalSheet();

            for (int i = 0; i < playersTeamA.size(); i++) {

                Wearable InCurseWerableA = new Wearable();

                InCurseWerableA.setPlayer(playersTeamA.get(i));

                wearables.add(InCurseWerableA);

            }

            for (int i = 0; i < playersTeamB.size(); i++) {

                Wearable InCurseWerableB = new Wearable();

                InCurseWerableB.setPlayer(playersTeamB.get(i));

                wearables.add(InCurseWerableB);

            }

        }
        else{
            throw new Exception("Vous ne devez ajoutez que 2 equipes sur la feuille de match");
        }

    }

    public MatchSheet(){

    }

    public List<Player> checkTeam(List<Player> playerList ){

        List<Player> selectedPlayer = new ArrayList<>();
        List<Player> substitutePlayer = new ArrayList<>();

        if (playerList.size() <= competitionType.playerMax && playerList.size() >= competitionType.playerMin) {

            for (int i = 0;  i<playerList.size(); i++) {

               boolean isSelected = playerList.get(i).isSelected();
               boolean isSubstitute = playerList.get(i).isSelected();
               if(isSelected){

                   selectedPlayer.add(playerList.get(i));
               }if(isSubstitute){

                    selectedPlayer.add(playerList.get(i));
                    substitutePlayer.add(playerList.get(i));
                }

            }

        }

        return selectedPlayer;


    }

    public void selectedPlayer(List<Player> playerList, Player player){

        for (int i = 0; i <=competitionType.playerMax ; i++) {

            playerList.get(i).setSelected(true);

        }

    }

    public void substitutePlayer(List<Player> playerList, Player player){

        for (int i = 0; i <=competitionType.playerMax ; i++) {

            playerList.get(i).setSelected(true);
            playerList.get(i).setSubstitute(true);

        }

}

    public void setId(Long id) {
        this.id = id;
    }

    public List<Team> getTeam() {
        return team;
    }

    public void setTeam(List<Team> team) {
        this.team = team;
    }

    public Events getEvent() {
        return event;
    }

    public void setEvent(Events event) {
        this.event = event;
    }

    public Stade getStade() {
        return stade;
    }

    public void setStade(Stade stade) {
        this.stade = stade;
    }

    public List<Scoot> getMatchScoots() {
        return matchScoots;
    }

    public void setMatchScoots(List<Scoot> matchScoots) {
        this.matchScoots = matchScoots;
    }

    public Saison getSaison() {
        return saison;
    }

    public void setSaison(Saison saison) {
        this.saison = saison;
    }

    public Competition getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(Competition competitionType) {
        this.competitionType = competitionType;
    }


    public List<Wearable> getWearables() {
        return wearables;
    }

    public void setWearables(List<Wearable> wearables) {
        this.wearables = wearables;
    }

    @Override
    public String toString() {
        return this.id.toString();
    }


}
