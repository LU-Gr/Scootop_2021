package com.projet.scootop.model.domainuser;

import com.projet.scootop.model.domainconfiguration.CompetitionTypeDTO;
import com.projet.scootop.model.domainconfiguration.TeamDTO;
import com.projet.scootop.model.domaintools.SaisonDTO;

import lombok.Getter;
import lombok.Setter;

public class FicheJoueurDTO {
	
	@Getter 
	private SaisonDTO saison;
	
	@Getter
	private CompetitionTypeDTO competitionType;
	
	@Getter
	private TeamDTO team;
	
	@Getter @Setter
	private Long playerId;
	
	@Setter
	private String playerFirstName;
	
	@Setter
	private String playerLastName;
	
	@Setter
	private String photoUrl;
	
	@Setter
	private int nbMatchPlayed;
	
	@Setter
	private int nbMinutePlayed;
	
	@Setter
	private int nbGoals;
	
	@Setter
	private int nbSuccededPasses;
	
	@Setter
	private int nbShootsInBox;
	
	@Setter
	private int nbSuccededDribbles;
	
	@Setter
	private int nbBallonsRecuperes;

}
