package com.projet.scootop.scootop.domain.domainconfiguration;

import com.projet.scootop.scootop.domain.domainuser.Coach;
import com.projet.scootop.scootop.domain.domainuser.Player;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Team")

//TODO: Ajouter competitionType
public class Team {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    //TODO Add relation ManyToOne
    public Club club;

    public String name;

    @ManyToMany
    @JoinTable(name = "team_coach", joinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "coach_id", referencedColumnName = "id"))
    public List<Coach> coaches;

    @ManyToMany
    @JoinTable(name = "team_player", joinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"))
    public List<Player> players;

    @OneToOne
    @JoinColumn(name = "category")
    public Category category;


    public Team(Club club, Category category,List<Player> players, List<Coach> coaches) throws Exception {
        this.club = club;
        this.category = category;

        if(players.size() >= 3 || players.size() <= 22) {

            for (int i = 0; i < players.size(); i++) {

                LocalDate playerBirthday = players.get(i).birthday;

                int agePlayer = category.categoryType.CategoryCalcul(playerBirthday);

                if(agePlayer > category.categoryType.ageMax){

                    throw new Exception("Joueur trop agé");

                }else if (agePlayer < category.categoryType.ageMin){

                    throw new Exception("Joueur trop jeune pour cette catégorie");

                }

            }
        }else{

            throw new Exception("Une equipe ne peut contenir plus de 22 Joueurs et doit avoir un minimum de 3 Joueurs ");
        }
        if(coaches.size() >= 0 || coaches.size() <= 3) {

            for (int i = 0; i < coaches.size(); i++) {
                Coach coach=coaches.get(i);
                if(coach.teams.size()>3){
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


    public Club getClub() {
        return club;
    }

    public void setClub(Club club){
        this.club = club;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
