package com.projet.scootop.scootop.servicetools.videosservices;

import javax.persistence.*;

import com.projet.scootop.scootop.domain.domaintools.CompetitionType;
import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.services.Events;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @ManyToOne

    @JoinColumn(name="videos_player",referencedColumnName = "id")
    Player player;

    String url;

    @ManyToOne
    @JoinColumn(name="event_videos",referencedColumnName = "id")
    Events events;

    Date posted;

    @OneToOne
    CompetitionType competition;

    @OneToMany
    @JoinColumn(name="video_keywords",referencedColumnName = "id")
    List<SearchKeyWord> keyword;

    @OneToMany
    @JoinColumn(name="video_view",referencedColumnName = "id")
    List<VideoView> view;


    public Video() {
    }
}
