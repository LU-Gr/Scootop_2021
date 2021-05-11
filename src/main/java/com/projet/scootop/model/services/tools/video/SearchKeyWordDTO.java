package com.projet.scootop.model.services.tools.video;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class SearchKeyWordDTO {
	
	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
    private String name;
	
	@Getter @Setter
    private List<VideoDTO> videos;

}
