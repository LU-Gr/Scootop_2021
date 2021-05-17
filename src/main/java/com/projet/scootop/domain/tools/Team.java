package com.projet.scootop.domain.tools;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.domain.configuration.Category;
import com.projet.scootop.domain.configuration.CompetitionType;
import com.projet.scootop.domain.user.domain.Coach;
import com.projet.scootop.domain.user.domain.Player;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String name;

    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private Club club;
    
    @ManyToOne
    @Getter @Setter
    private CompetitionType competitionType;
    
    @ManyToOne
    @Getter @Setter
    private Category category;

    @ManyToMany
    @JoinTable(name = "team_coach", 
    			joinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"),
    			inverseJoinColumns = @JoinColumn(name = "coach_id", referencedColumnName = "id"))
    @Getter @Setter
    private List<Coach> coaches;

    @ManyToMany
    @JoinTable(name = "player_team", 
    			joinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"),
    			inverseJoinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"))
    @Getter @Setter
    @JsonIgnoreProperties("team")
    private List<Player> players;

   

    public Team(Club club, Category category,List<Player> players, List<Coach> coaches) throws Exception {
        this.club = club;
        this.category = category;

        if(players.size() >= 3 || players.size() <= 22) {
            for (int i = 0; i < players.size(); i++) {
                LocalDate playerBirthday = players.get(i).getUser().getBirthday();
                int agePlayer = category.getCategoryType().CategoryCalcul(playerBirthday);
                if(agePlayer > category.getCategoryType().getAgeMax()){
                    throw new Exception("Joueur trop agé");
                }else if (agePlayer < category.getCategoryType().getAgeMin()){
                    throw new Exception("Joueur trop jeune pour cette catégorie");
                }
            }
        }else{
            throw new Exception("Une equipe ne peut contenir plus de 22 Joueurs et doit avoir un minimum de 3 Joueurs ");
        }
        if(coaches.size() >= 0 || coaches.size() <= 3) {
            for (int i = 0; i < coaches.size(); i++) {
                Coach coach=coaches.get(i);
                if(coach.getTeams().size()>3){
                    throw new Exception("Un coach ne peut pas entrainer plus de 3 équipes");
                }
            }
        }else{

            throw new Exception("Une equipe ne peut contenir plus de 22 Joueurs et doit avoir un minimum de 3 Joueurs ");
        }
        
        this.players=players;
        this.coaches=coaches;
    }

    public Team(){
    	players = new ArrayList<>();
    }
}
