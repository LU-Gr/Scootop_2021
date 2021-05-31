package com.projet.scootop.model.services.tools.video;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

public class SearchKeyWordDTO {
	
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
    private String name;
	
	@Getter @Setter
	@JsonIgnoreProperties("keywords")
    private List<VideoDTO> videos;

}
