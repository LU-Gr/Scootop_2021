package com.projet.scootop.model.tools;

import com.projet.scootop.model.configuration.CompetitionTypeDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class CompetitionDTO {
	
	@Getter @Setter
	private Long id;	
	
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
	private int dureeMiTemps;
	
	@Getter @Setter
	private CompetitionTypeDTO competitionType;

}
