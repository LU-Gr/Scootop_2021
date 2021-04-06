package com.projet.scootop.scootop.model.services;

import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.domaintools.Competition;
import com.projet.scootop.scootop.domain.domaintools.Saison;
import com.projet.scootop.scootop.domain.domainuser.Scoot;
import com.projet.scootop.scootop.domain.services.GameSheet;
import com.projet.scootop.scootop.domain.servicetools.videosservices.Video;

import java.time.LocalDate;
import java.util.List;

public class EventsDTO {

    public Long id;
    public LocalDate date;
    public Competition competitiontype;
    public List <Team> teams;
    public List <Scoot> scoots;
    public List <GameSheet> gameSheets;
    public boolean status;
    public boolean prestaAnalyst;
    public boolean prestaCameraman;
    public boolean prestaWearable;
    public boolean prestaScoot;
    public boolean prestaZoom;
    public Saison saison;
    public List<Video> videos;

    public static EventsDTO create(Long id, LocalDate date,Competition competitiontype, List<Team> teams, List<Scoot> scoots,List<GameSheet> gameSheets, boolean status, boolean prestaAnalyst, boolean prestaCameraman, boolean prestaWearable, boolean prestaScoot, boolean prestaZoom, Saison saison, List<Video> videos) {
        EventsDTO events = new EventsDTO();

        events.id = id;
        events.date = date;
        events.competitiontype = competitiontype;
        events.teams = teams;
        events.scoots = scoots;
        events.gameSheets = gameSheets;
        events.status = status;
        events.prestaAnalyst = prestaAnalyst;
        events.prestaCameraman = prestaCameraman;
        events.prestaWearable = prestaWearable;
        events.prestaScoot = prestaScoot;
        events.prestaZoom = prestaZoom;
        events.saison = saison;
        events.videos = videos;

        return events;
    }

    public static EventsDTO get(Long id, LocalDate date,Competition competitiontype, List<Team> teams, List<Scoot> scoots,List<GameSheet> gameSheets, boolean status, boolean prestaAnalyst, boolean prestaCameraman, boolean prestaWearable, boolean prestaScoot, boolean prestaZoom, Saison saison, List<Video> videos) {
        EventsDTO events = new EventsDTO();

        events.id = id;
        events.date = date;
        events.competitiontype = competitiontype;
        events.teams = teams;
        events.scoots = scoots;
        events.gameSheets = gameSheets;
        events.status = status;
        events.prestaAnalyst = prestaAnalyst;
        events.prestaCameraman = prestaCameraman;
        events.prestaWearable = prestaWearable;
        events.prestaScoot = prestaScoot;
        events.prestaZoom = prestaZoom;
        events.saison = saison;
        events.videos = videos;

        return events;
    }

}
