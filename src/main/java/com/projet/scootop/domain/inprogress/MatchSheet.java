package com.projet.scootop.domain.inprogress;

import javax.persistence.*;

import com.projet.scootop.domain.domainconfiguration.Stade;
import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.domaintools.Competition;
import com.projet.scootop.domain.domaintools.Saison;
import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.domainuser.Scoot;
import com.projet.scootop.domain.services.Events;
import com.projet.scootop.domain.services.Wearable;

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
    private Events event;
    
    //TODO: Remplacer en mettant 2 Team
    @OneToMany
    @JoinColumn(name="Match_Sheet_teams",referencedColumnName = "id")
    @Getter @Setter
    private List<Team> team;

    @OneToMany
    @JoinColumn(name="Match_Sheet_statistical",referencedColumnName = "id")
    @Getter @Setter
    private List<StatisticalSheet> statisticalSheets;
    
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
    private Competition competitionType;

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

        if (playerList.size() <= competitionType.getNbPlayerMax() && playerList.size() >= competitionType.getNbPlayerMin()) {
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
        for (int i = 0; i <=competitionType.getNbPlayerMax() ; i++) {
            playerList.get(i).setSelected(true);
        }

    }

    public void substitutePlayer(List<Player> playerList, Player player){
        for (int i = 0; i <=competitionType.getNbPlayerMax() ; i++) {
            playerList.get(i).setSelected(true);
            playerList.get(i).setSubstitute(true);

        }

    }

}
