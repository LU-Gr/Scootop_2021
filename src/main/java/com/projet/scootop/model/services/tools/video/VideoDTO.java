package com.projet.scootop.model.services.tools.video;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

import com.projet.scootop.domain.configuration.CompetitionType;
import com.projet.scootop.domain.services.Event;
import com.projet.scootop.domain.services.tools.video.SearchKeyWord;
import com.projet.scootop.domain.user.domainuser.Player;

public class VideoDTO {

	@Getter @Setter
    private Integer id;

    @Getter @Setter
    private Player player;

    @Getter @Setter
    private String url;

    @Getter @Setter
    private Event events;

    @Getter @Setter
    private Date posted;

    @Getter @Setter
    private CompetitionType competition;

    @Getter @Setter
    private List<SearchKeyWord> keyword;

    @Getter @Setter
    private List<VideoViewDTO> view;

}