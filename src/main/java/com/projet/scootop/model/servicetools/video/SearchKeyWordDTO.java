package com.projet.scootop.model.servicetools.video;

import java.util.List;

import com.projet.scootop.domain.servicetools.video.Video;

import lombok.Getter;
import lombok.Setter;

public class SearchKeyWordDTO {
	
	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
    private String name;
	
	@Getter @Setter
    private List<Video> videos;

}
