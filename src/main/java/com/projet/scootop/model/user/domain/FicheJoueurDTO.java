package com.projet.scootop.model.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
	private String playerFirstName;
	
	@Getter @Setter
	private String playerLastName;
	
	@Getter @Setter
	private String photoUrl;
	
	@Getter @Setter
	private int nbMatchPlayed;
	
	@Getter @Setter
	private int nbMatchWon;
	
	@Getter @Setter
	private int nbMinutePlayed;
	
	@Getter @Setter
	private int nbGoals;
	
	@Setter
	private int nbPasses;

	@Setter
	private int nbShoots;

	@Setter
	private int nbSkills;
	
	@Setter
	private int nbAssists;
	
	@Setter
	private int nbSucceededSkills;
	
	@Getter @Setter
	private int nbSucceededPasses;
	
	@Getter @Setter
	private int nbShootsInBox;
	
	@Getter @Setter
	private int nbSucceededDribbles;
	
	@Getter @Setter
	private int nbBallsRecuperes;
	
	@Setter 
	private int nbBallsPlayed;
	
	@Setter 
	private int nbBallsLost;
	

}
