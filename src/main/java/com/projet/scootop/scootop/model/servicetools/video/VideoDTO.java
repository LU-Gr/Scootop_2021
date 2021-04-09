package com.projet.scootop.scootop.model.servicetools.video;

import com.projet.scootop.scootop.domain.domainconfiguration.CompetitionType;
import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.services.Events;
import com.projet.scootop.scootop.domain.servicetools.video.SearchKeyWord;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

public class VideoDTO {

	@Getter @Setter
    private Integer id;

    @Getter @Setter
    private Player player;

    @Getter @Setter
    private String url;

    @Getter @Setter
    private Events events;

    @Getter @Setter
    private Date posted;

    @Getter @Setter
    private CompetitionType competition;

    @Getter @Setter
    private List<SearchKeyWord> keyword;

    @Getter @Setter
    private List<VideoViewDTO> view;

}