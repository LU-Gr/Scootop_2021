package com.projet.scootop.domain.domainconfiguration;

import javax.persistence.*;

import com.projet.scootop.domain.domaintools.Competition;
import com.projet.scootop.domain.domaintools.Saison;
import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.domainuser.Scoot;
import com.projet.scootop.domain.services.Event;
import com.projet.scootop.domain.services.Wearable;
import com.projet.scootop.domain.statistical.StatisticalSheet;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

// Feuille de match
@Entity
@Table(name = "MatchSheet")
//TODO: Renommer en match
public class MatchSheet {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @OneToOne
    @Getter @Setter
    private Event event;
    
    @ManyToOne
    @Getter @Setter
    private Team teamA;
    
    @ManyToOne
    @Getter @Setter
    private Team teamB;
    
    @OneToMany
    @Getter @Setter
    private List<StatisticalSheet> statisticalSheetsTeamA;
    
    @OneToMany
    @Getter @Setter
    private List<StatisticalSheet> statisticalSheetsTeamB;
    
    @OneToOne
    @Getter @Setter
    private Stade stade;
    
    @ManyToMany
    @JoinColumn(name="Match_Sheet_scoot",referencedColumnName = "id")
    @Getter @Setter
    private List <Scoot> matchScoots;

    @OneToMany
    @JoinColumn(name="Match_Sheet_wearable",referencedColumnName = "id")
    @Getter @Setter
    private List<Wearable> wearables;

    @ManyToOne
    @JoinColumn(name = "SAISON_ID")
    @Getter @Setter
    private Saison saison;

    @OneToOne
    @Getter @Setter
    private Competition competition;

    public MatchSheet(Event event, Team teamA, Team teamB, Stade stade, List<Scoot> matchScoots, List<Wearable> wearables, Saison saison, Competition competition) throws Exception {
        this.event = event;
        this.competition = competition;
        this.stade = stade;
        this.matchScoots = matchScoots;
        this.saison = saison;
        this.wearables = wearables;
        this.teamA = teamA;
        this.teamB = teamB;

        List<Player>  playersTeamA = this.teamA.getPlayers();
        List<Player>  playersTeamB = this.teamA.getPlayers();
        statisticalSheetsTeamA = new ArrayList<>();
        statisticalSheetsTeamB = new ArrayList<>();
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

    public MatchSheet(){

    }

    public List<Player> checkTeam(List<Player> playerList ){

        List<Player> selectedPlayer = new ArrayList<>();
        List<Player> substitutePlayer = new ArrayList<>();

        if (playerList.size() <= competition.getNbPlayerMax() && playerList.size() >= competition.getNbPlayerMin()) {
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
        for (int i = 0; i <=competition.getNbPlayerMax() ; i++) {
            playerList.get(i).setSelected(true);
        }

    }

    public void substitutePlayer(List<Player> playerList, Player player){
        for (int i = 0; i <=competition.getNbPlayerMax() ; i++) {
            playerList.get(i).setSelected(true);
            playerList.get(i).setSubstitute(true);

        }

    }

}
