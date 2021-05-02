package com.projet.scootop.domain.servicetools.video;

import javax.persistence.*;

import com.projet.scootop.domain.domainconfiguration.CompetitionType;
import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.services.Event;

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
    @JoinColumn(name="videos_player",referencedColumnName = "id")
    @Getter @Setter
    private Player player;

    @Getter @Setter
    private String url;

    @ManyToOne
    @JoinColumn(name="event_videos",referencedColumnName = "id")
    @Getter @Setter
    private Event events;

    @Getter @Setter
    private Date posted;

    @OneToOne
    @Getter @Setter
    private CompetitionType competition;

    @ManyToMany
    @Getter @Setter
    private List<SearchKeyWord> keyword;

    @OneToMany
    @Getter @Setter
    @JoinColumn(name="video_view",referencedColumnName = "id")
    private List<VideoView> view;


    public Video() {
    }
}