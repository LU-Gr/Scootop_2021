package com.projet.scootop.model.tools;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.model.configuration.CategoryDTO;
import com.projet.scootop.model.configuration.CompetitionTypeDTO;
import com.projet.scootop.model.user.domain.CoachDTO;
import com.projet.scootop.model.user.domain.PlayerDTO;

import lombok.Getter;
import lombok.Setter;

public class TeamDTO {

	@Getter @Setter
    private Long id;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	@JsonIgnoreProperties({"teams"})
	private ClubDTO club;
	
	@Getter @Setter
    private CompetitionTypeDTO competitionType;
	
	@Getter @Setter
	private CategoryDTO category;
	
	@Getter @Setter
	@JsonIgnoreProperties({"teams"})
	private List<CoachDTO> coaches;
	
	@Getter @Setter
	@JsonIgnoreProperties({"teams","statisticalSheets"})
	private List<PlayerDTO> players;

}