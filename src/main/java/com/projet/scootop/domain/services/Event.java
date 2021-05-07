package com.projet.scootop.domain.services;

import javax.persistence.*;

import com.projet.scootop.domain.services.tools.video.Video;
import com.projet.scootop.domain.tools.Competition;
import com.projet.scootop.domain.tools.Saison;
import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.domain.user.domainuser.Scoot;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity

@Table(name = "Event")

public class Event {

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

    public Event() {

    }

    public Event(Long id, LocalDate date, Competition competitiontype, List<Team> teams, List<Scoot> scoots, boolean status, boolean prestaAnalyst, boolean prestaCameraman, boolean prestaWearable, boolean prestaScoot, boolean prestaZoom, Saison saison, List<Video> videos) {
    }

}
