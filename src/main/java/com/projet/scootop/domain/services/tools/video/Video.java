package com.projet.scootop.domain.services.tools.video;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.domain.configuration.CompetitionType;
import com.projet.scootop.domain.services.Event;
import com.projet.scootop.domain.user.domain.Player;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @Getter @Setter
    @JsonIgnoreProperties({"videos","statisticalSheets"})
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
    @JsonIgnoreProperties("videos")
    private Event event;

    @OneToMany
    @Getter @Setter
    @JoinColumn(name="video_id",referencedColumnName = "id")
    @JsonIgnoreProperties("video")
    private List<VideoView> views;
    
    @ManyToMany
    @Getter @Setter
    @JsonIgnoreProperties("videos")
    private List<SearchKeyWord> keywords;

    public Video() {
    	views = new ArrayList<>();
    	keywords = new ArrayList<>();
    }
}