package com.projet.scootop.scootop.domain.domainconfiguration;

import com.projet.scootop.scootop.domain.domainuser.Coach;
import com.projet.scootop.scootop.domain.domainuser.Player;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Team")
public class Team {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private Club club;
    
    @ManyToOne
    @Getter @Setter
    private CompetitionType competitionType;
    
    @Getter @Setter
    private String name;

    @ManyToMany
    @JoinTable(name = "team_coach", joinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "coach_id", referencedColumnName = "id"))
    @Getter @Setter
    private List<Coach> coaches;

    @ManyToMany
    @JoinTable(name = "team_player", joinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"))
    @Getter @Setter
    private List<Player> players;

    @OneToMany
    @Getter @Setter
    private Category category;


    public Team(Club club, Category category,List<Player> players, List<Coach> coaches) throws Exception {
        this.club = club;
        this.category = category;

        if(players.size() >= 3 || players.size() <= 22) {
            for (int i = 0; i < players.size(); i++) {
                LocalDate playerBirthday = players.get(i).birthday;
                int agePlayer = category.categoryType.CategoryCalcul(playerBirthday);
                if(agePlayer > category.categoryType.getAgeMax()){
                    throw new Exception("Joueur trop agé");
                }else if (agePlayer < category.categoryType.getAgeMin()){
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

    }
}
