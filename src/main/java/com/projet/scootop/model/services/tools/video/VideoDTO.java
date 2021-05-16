package com.projet.scootop.model.services.tools.video;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

import com.projet.scootop.domain.services.tools.video.SearchKeyWord;
import com.projet.scootop.domain.user.domain.Player;
import com.projet.scootop.model.configuration.CompetitionTypeDTO;
import com.projet.scootop.model.services.EventDTO;

public class VideoDTO {

	@Getter @Setter
    private Integer id;

    @Getter @Setter
    private Player player;

    @Getter @Setter
    private String url;

    @Getter @Setter
    private Date posted;
    
    @Getter @Setter
    private EventDTO event;

    @Getter @Setter
    private CompetitionTypeDTO competitionType;

    @Getter @Setter
    private List<VideoViewDTO> views;
    
    @Getter @Setter
    private List<SearchKeyWordDTO> keywords;

}