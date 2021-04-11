package com.projet.scootop.domain.services;

import javax.persistence.*;

import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.domaintools.Competition;
import com.projet.scootop.domain.domaintools.Saison;
import com.projet.scootop.domain.domainuser.Scoot;
import com.projet.scootop.domain.servicetools.video.Video;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity

@Table(name = "Events")

public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private LocalDate date;
    
    @OneToOne
    @Getter @Setter
    private Competition competition;
    
    @OneToMany
    @Getter @Setter
    private List <Team> teams;
    
    @OneToMany
    @Getter @Setter
    private List <Scoot> scoots;

    //TODO: supprimer gameSheets
    @OneToMany
    @Getter @Setter
    private List <GameSheet> gameSheets;
    
    @Getter @Setter
    private boolean status;
    
    @Getter @Setter
    private boolean prestaAnalyst;
    
    @Getter @Setter
    private boolean prestaCameraman;
    
    @Getter @Setter
    private boolean prestaWearable;
    
    @Getter @Setter
    private boolean prestaScoot;
    
    @Getter @Setter
    private boolean prestaZoom;
    
    //TODO: Ajouter liste pour lers presta bool

    @ManyToOne
    @JoinColumn(name = "saison_id")
    @Getter @Setter
    private Saison saison;

    @OneToMany
    @JoinColumn(name="events_video",referencedColumnName = "id")
    @Getter @Setter
    private List<Video> videos;

    public Events() {

    }

    public Events(Long id, LocalDate date, Competition competitiontype, List<Team> teams, List<Scoot> scoots, List<GameSheet> gameSheets, boolean status, boolean prestaAnalyst, boolean prestaCameraman, boolean prestaWearable, boolean prestaScoot, boolean prestaZoom, Saison saison, List<Video> videos) {
    }

}
