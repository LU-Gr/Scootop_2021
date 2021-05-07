package com.projet.scootop.domain.user.domainuser;

import javax.persistence.*;

import com.projet.scootop.domain.configuration.Category;
import com.projet.scootop.domain.configuration.Poste;
import com.projet.scootop.domain.services.tools.video.Video;
import com.projet.scootop.domain.tools.Match;
import com.projet.scootop.domain.tools.StatisticalSheet;
import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.domain.user.User;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "PLAYER")
public class Player{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @OneToOne
    @Getter @Setter
    private User user;

    @ManyToMany(mappedBy = "players")
    @Getter @Setter
    private List<Team> teams;
    
    @ManyToMany
    @Getter @Setter
    private List<Poste> postes;

    @OneToOne
    @Getter @Setter
    private Category category;

    @Getter @Setter
    private Double rating;
    
    @Getter @Setter
    private int taille;
    
    @Getter @Setter
    private int poids;
    
    @Getter @Setter
    private int vma;
    
    @Getter @Setter
    private String nationalite;
    
    @Getter @Setter
    private String origin;

    @Getter @Setter
    private boolean isSelected; // sert a dire si joueur en train de jouer en temps réel
    
    @Getter @Setter
    private boolean isSubstitute; // Sert a dire si il est remplacant

    @Getter @Setter
    private String strongFoot;

    @Getter @Setter
    private String weekFoot;
    
    @Getter @Setter
    private String photoUrl;

    @OneToMany
    @Getter @Setter
    private List<StatisticalSheet> statisticalSheets;

    //TODO : dégager
    @OneToMany
    @Getter @Setter
    private List<Match> matchSheets;
    
    //@OneToMany
    //@Getter @Setter
	//private List<Photo> photos;
    
    @OneToMany
    @JoinColumn(name="player_videos",referencedColumnName = "id")
    @Getter @Setter
    private List<Video> videos;

   public Player(List<Team> teams, Category category, Double rating, int taille, int poids, int vma, String nationalite, String origin, String strongFoot, String weekFoot, List<StatisticalSheet> statisticalSheets, List<Match> matchSheets, List<Video> videos, boolean selected, User user) {
        super();
        this.teams = teams;
        this.category = category;
        this.rating = rating;
        this.taille = taille;
        this.poids = poids;
        this.vma = vma;
        this.nationalite = nationalite;
        this.origin = origin;
        this.strongFoot = strongFoot;
        this.weekFoot = weekFoot;
        this.statisticalSheets = statisticalSheets;
        this.matchSheets = matchSheets;
        this.videos = videos;
        this.isSelected = selected;
        this.user = user;
    }

    public Player() {
    }

}
