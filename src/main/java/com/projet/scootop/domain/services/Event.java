package com.projet.scootop.domain.services;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.domain.services.tools.video.Video;
import com.projet.scootop.domain.tools.Competition;
import com.projet.scootop.domain.tools.Saison;
import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.domain.user.domain.Scoot;
import com.projet.scootop.domain.user.provider.Analyst;
import com.projet.scootop.domain.user.provider.Cameraman;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@ToString
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private LocalDate date;
    
    @Getter @Setter
    private boolean status;
    
    @Getter @Setter
    private boolean prestaWearable;

    @Getter @Setter
    private boolean prestaZoom;
    
    @OneToMany
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    @Getter @Setter
    @JsonIgnoreProperties("event")
    private List<Video> videos;
    
    @ManyToOne
    @Getter @Setter
    private Competition competition;
    
    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private Saison saison;
    
    @ManyToMany
    @Getter @Setter
    private List<Team> teams;
    
    @ManyToMany
    @Getter @Setter
    private List<Scoot> scoots;
    
    @ManyToMany
    @Getter @Setter
    private List<Analyst> analysts;
    
    @ManyToMany
    @Getter @Setter
    private List<Cameraman> cameramans;
    

    public Event() {

    }

}
