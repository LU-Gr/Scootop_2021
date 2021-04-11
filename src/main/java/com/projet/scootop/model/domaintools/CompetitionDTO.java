package com.projet.scootop.model.domaintools;

import com.projet.scootop.model.domainconfiguration.CategoryDTO;
import com.projet.scootop.model.domainconfiguration.CompetitionTypeDTO;
import com.projet.scootop.model.servicetools.video.VideoDTO;

import lombok.Getter;
import lombok.Setter;

public class CompetitionDTO {
	
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private VideoDTO video;
	
	@Getter @Setter
	private CompetitionTypeDTO competitionType;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private int playerMax;
	
	@Getter @Setter
	private int playerMin;

	@Getter @Setter
	private int titulaire;
	
	@Getter @Setter
	private int remplacant;

	@Getter @Setter
	private int substition;
	
	@Getter @Setter
	private CategoryDTO category;
	
	@Getter @Setter
	private int time;

}
