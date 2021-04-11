package com.projet.scootop.domain.domainuser;

import javax.persistence.*;

import com.projet.scootop.domain.domainconfiguration.Category;
import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.inprogress.MatchSheet;
import com.projet.scootop.domain.inprogress.StatisticalSheet;
import com.projet.scootop.domain.servicetools.video.Video;
import com.projet.scootop.domain.statistical.physical.PlayerHead;
import com.projet.scootop.domain.user.User;

import java.time.LocalDate;
import java.util.List;

//TODO: Ajouter Liste de poste
@Entity
@Table(name = "PLAYER")
public class Player{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToOne
    public User user;

    @ManyToMany (mappedBy = "players")
    public List<Team> teams;

    @OneToOne
    public Category category;

    public int evaluation;

    //TODO Déplacer dans User
    public LocalDate birthday;
    
    public int taille;
    public int poids;
    public int vma;
    public String nationalite;
    public String origin;
    //TODO: Supprimer Interaction
    public int interaction;

    public boolean selected; // sert a dire si joueur en train de jouer en temps réel
    
    public boolean substitute; // Sert a dire si il est remplacant

    public String strongFoot;

    public String weekFoot;

    @OneToMany
    public List<StatisticalSheet> statisticalSheets;

    @OneToMany
    public List<MatchSheet> matchSheets;
    //TODO: Supprimer
    @OneToOne
    public PlayerHead playerHead;
/*
    @ManyToOne
    @JoinColumn(name="player_feet",referencedColumnName = "id")
    Foot[] Feet = new Foot[2];*/




    @OneToMany

    @JoinColumn(name="player_videos",referencedColumnName = "id")
    public List<Video> videos;

   public Player(List<Team> teams, Category category, int evaluation, LocalDate birthday, int taille, int poids, int vma, String nationalite, String origin, int interaction, String strongFoot, String weekFoot, List<StatisticalSheet> statisticalSheets, PlayerHead playerHead, List<MatchSheet> matchSheets, List<Video> videos, boolean selected, User user) {
        super();
        this.teams = teams;
        this.category = category;
        this.evaluation = evaluation;
        this.birthday = birthday;
        this.taille = taille;
        this.poids = poids;
        this.vma = vma;
        this.nationalite = nationalite;
        this.origin = origin;
        this.interaction = interaction;
        this.strongFoot = strongFoot;
        this.weekFoot = weekFoot;
        this.statisticalSheets = statisticalSheets;
        this.matchSheets = matchSheets;
        this.playerHead = playerHead;
        this.videos = videos;
        this.selected = selected;
        this.user = user;
    }


    public Player() {
    }


    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSubstitute() {
        return substitute;
    }

    public void setSubstitute(boolean substitute) {
        this.substitute = substitute;
    }


    public List<MatchSheet> getMatchSheets() {
        return matchSheets;
    }

    public void setMatchSheets(List<MatchSheet> matchSheets) {
        this.matchSheets = matchSheets;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
