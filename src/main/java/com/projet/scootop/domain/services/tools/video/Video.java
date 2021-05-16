package com.projet.scootop.domain.services.tools.video;

import javax.persistence.*;

import com.projet.scootop.domain.configuration.CompetitionType;
import com.projet.scootop.domain.services.Event;
import com.projet.scootop.domain.user.domain.Player;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @Getter @Setter
    private Player player;

    @Getter @Setter
    private String url;
    
    @Getter @Setter
    private Date posted;
    
    @ManyToOne
    @Getter @Setter
    private CompetitionType competitionType;

    @ManyToOne
    @Getter @Setter
    private Event event;

    @OneToMany
    @Getter @Setter
    @JoinColumn(name="video_id",referencedColumnName = "id")
    private List<VideoView> views;
    
    @ManyToMany
    @Getter @Setter
    private List<SearchKeyWord> keywords;

    public Video() {
    }
}