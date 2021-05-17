package com.projet.scootop.model.user.domain;

import com.projet.scootop.model.configuration.CompetitionTypeDTO;
import com.projet.scootop.model.tools.SaisonDTO;
import com.projet.scootop.model.tools.TeamDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class FicheJoueurDTO {
	
	@Getter 
	private SaisonDTO saison;
	
	@Getter
	private CompetitionTypeDTO competitionType;
	
	@Getter
	private TeamDTO team;
	
	@Getter @Setter
	private Long playerId;
	
	@Getter @Setter
	private String playerFirstName;
	
	@Getter @Setter
	private String playerLastName;
	
	@Getter @Setter
	private String photoUrl;
	
	@Getter @Setter
	private int nbMatchPlayed;
	
	@Getter @Setter
	private int nbMinutePlayed;
	
	@Getter @Setter
	private int nbGoals;
	
	@Getter @Setter
	private int nbSuccededPasses;
	
	@Getter @Setter
	private int nbShootsInBox;
	
	@Getter @Setter
	private int nbSuccededDribbles;
	
	@Getter @Setter
	private int nbBallonsRecuperes;

}
