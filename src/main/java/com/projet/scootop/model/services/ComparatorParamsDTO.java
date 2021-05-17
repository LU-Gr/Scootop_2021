package com.projet.scootop.model.services;

import com.projet.scootop.model.configuration.CompetitionTypeDTO;
import com.projet.scootop.model.tools.SaisonDTO;
import com.projet.scootop.model.tools.TeamDTO;

import lombok.Getter;
import lombok.ToString;

@ToString
public class ComparatorParamsDTO {
	
	@Getter 
	private SaisonDTO saison;
	
	@Getter
	private CompetitionTypeDTO competitionType;
	
	@Getter
	private TeamDTO team;
	
	@Getter
	private Long playerAId;
	
	@Getter
	private Long playerBId;

}
