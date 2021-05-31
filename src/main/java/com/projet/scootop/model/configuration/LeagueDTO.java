package com.projet.scootop.model.configuration;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.model.tools.SaisonDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class LeagueDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	@JsonIgnoreProperties("league")
	private List<DivisionDTO> divisions;
	
	@Getter @Setter
    private CompetitionTypeDTO competitionType;
	
	@Getter @Setter
	private SaisonDTO saison;

}
