package com.projet.scootop.model.tools;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import com.projet.scootop.domain.configuration.CompetitionType;
import com.projet.scootop.model.configuration.CategoryDTO;
import com.projet.scootop.model.configuration.CompetitionTypeDTO;
import com.projet.scootop.model.user.domain.CoachDTO;
import com.projet.scootop.model.user.domain.PlayerDTO;

@ToString
public class TeamDTO {

	@Getter @Setter
    private Long id;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private ClubDTO club;
	
	@Getter @Setter
    private CompetitionTypeDTO competitionType;
	
	@Getter @Setter
	private CategoryDTO category;
	
	@Getter @Setter
	private List<CoachDTO> coaches;
	
	@Getter @Setter
	private List<PlayerDTO> players;

}