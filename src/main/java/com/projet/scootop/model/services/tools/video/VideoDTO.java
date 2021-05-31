package com.projet.scootop.model.services.tools.video;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.domain.user.domain.Player;
import com.projet.scootop.model.configuration.CompetitionTypeDTO;
import com.projet.scootop.model.services.EventDTO;

public class VideoDTO {

	@Getter @Setter
    private Long id;

    @Getter @Setter
    @JsonIgnoreProperties({"videos","statisticalSheets"})
    private Player player;

    @Getter @Setter
    private String url;

    @Getter @Setter
    private Date posted;
    
    @Getter @Setter
    @JsonIgnoreProperties("videos")
    private EventDTO event;

    @Getter @Setter
    private CompetitionTypeDTO competitionType;

    @Getter @Setter
    @JsonIgnoreProperties("video")
    private List<VideoViewDTO> views;
    
    @Getter @Setter
    @JsonIgnoreProperties("videos")
    private List<SearchKeyWordDTO> keywords;

}