package com.projet.scootop.scootop.domain.services;

import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.domaintools.CompetitionType;
import com.projet.scootop.scootop.domain.domaintools.Saison;
import com.projet.scootop.scootop.domain.domainuser.Scoot;
import com.projet.scootop.scootop.servicetools.videosservices.Video;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity

@Table(name = "Events")

public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public LocalDate date;
    
    

    @OneToOne
    public CompetitionType competitiontype;
    
    @OneToMany
    public List <Team> teams;
    
    @OneToMany
    public List <Scoot> scoots;

    //TODO: supprimer gameSheets
    @OneToMany
    public List <GameSheet> gameSheets;
    public boolean status;
    public boolean prestaAnalyst;
    public boolean prestaCameraman;
    public boolean prestaWearable;
    public boolean prestaScoot;
    public boolean prestaZoom;
    
    //TODO: Ajouter liste pour lers presta bool

    @ManyToOne
    @JoinColumn(name = "saison_id")
    public Saison saison;

    @OneToMany
    @JoinColumn(name="events_video",referencedColumnName = "id")
    public List<Video> videos;

    public Events() {

    }

    public Events(Integer id, LocalDate date, CompetitionType competitiontype, List<Team> teams, List<Scoot> scoots, List<GameSheet> gameSheets, boolean status, boolean prestaAnalyst, boolean prestaCameraman, boolean prestaWearable, boolean prestaScoot, boolean prestaZoom, Saison saison, List<Video> videos) {
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public CompetitionType getCompetitiontype() {
        return competitiontype;
    }

    public void setCompetitiontype(CompetitionType competiontype) {
        this.competitiontype = competiontype;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Scoot> getScoots() {
        return scoots;
    }

    public void setScoots(List<Scoot> scoots) {
        this.scoots = scoots;
    }

    public List<GameSheet> getGameSheets() {
        return gameSheets;
    }

    public void setGameSheets(List<GameSheet> gameSheets) {
        this.gameSheets = gameSheets;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isPrestaAnalyst() {
        return prestaAnalyst;
    }

    public void setPrestaAnalyst(boolean prestaAnalyst) {
        this.prestaAnalyst = prestaAnalyst;
    }

    public boolean isPrestaCameraman() {
        return prestaCameraman;
    }

    public void setPrestaCameraman(boolean prestaCameraman) {
        this.prestaCameraman = prestaCameraman;
    }

    public boolean isPrestaWearable() {
        return prestaWearable;
    }

    public void setPrestaWearable(boolean prestaWearable) {
        this.prestaWearable = prestaWearable;
    }

    public boolean isPrestaScoot() {
        return prestaScoot;
    }

    public void setPrestaScoot(boolean prestaScoot) {
        this.prestaScoot = prestaScoot;
    }

    public boolean isPrestaZoom() {
        return prestaZoom;
    }

    public void setPrestaZoom(boolean prestaZoom) {
        this.prestaZoom = prestaZoom;
    }

    public Saison getSaison() {
        return saison;
    }

    public void setSaison(Saison saison) {
        this.saison = saison;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
