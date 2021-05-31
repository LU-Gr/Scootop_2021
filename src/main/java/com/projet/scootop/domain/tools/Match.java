package com.projet.scootop.domain.tools;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.domain.configuration.Stade;
import com.projet.scootop.domain.services.Event;
import com.projet.scootop.domain.services.LocationWearable;
import com.projet.scootop.domain.user.domain.Player;
import com.projet.scootop.domain.user.domain.Scoot;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

// Feuille de match
@ToString
@Entity
@Table(name = "MatchSheet")
public class Match {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @OneToOne
    @Getter @Setter
    private Event event;
    
    @OneToOne
    @Getter @Setter
    private Competition competition;
    
    @ManyToOne
    @Getter @Setter
    private Team teamA;
    
    @ManyToOne
    @Getter @Setter
    private Team teamB;
    
    @ManyToOne
    @Getter @Setter
    private Stade stade;
    
    @ManyToOne
    @Getter @Setter
    private Saison saison;
    
    @OneToMany
    @Getter @Setter
    @JoinColumn(name="match_sheet_id", referencedColumnName="id")
    @JsonIgnoreProperties("match")
    private List<StatisticalSheet> statisticalSheetsTeamA;
    
    @OneToMany
    @Getter @Setter
    @JoinColumn(name="match_sheet_id", referencedColumnName="id")
    @JsonIgnoreProperties("match")
    private List<StatisticalSheet> statisticalSheetsTeamB;
    
    @OneToMany
    @JoinColumn(name = "match_id", referencedColumnName = "id")
    @Getter @Setter
    @JsonIgnoreProperties("match")
    private List<LocationWearable> wearables;
    
    @ManyToMany
    @JoinTable(name="match_sheet_club", 
	joinColumns = @JoinColumn(name ="match_sheet_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "scoot_id",referencedColumnName = "id"))
    @Getter @Setter
    private List <Scoot> scoots;

    
    public Match(Event event, Team teamA, Team teamB, Stade stade, List<Scoot> scoots, List<LocationWearable> wearables, Saison saison, Competition competition) throws Exception {
        this.event = event;
        this.competition = competition;
        this.stade = stade;
        this.scoots = scoots;
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
        	LocationWearable InCurseWerableA = new LocationWearable();
            InCurseWerableA.setPlayer(playersTeamA.get(i));
            wearables.add(InCurseWerableA);
        }

        for (int i = 0; i < playersTeamB.size(); i++) {
        	LocationWearable InCurseWerableB = new LocationWearable();
            InCurseWerableB.setPlayer(playersTeamB.get(i));
            wearables.add(InCurseWerableB);
        }
    }

    public Match(){
    	this.statisticalSheetsTeamA = new ArrayList<>();
    	this.statisticalSheetsTeamB = new ArrayList<>();
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
