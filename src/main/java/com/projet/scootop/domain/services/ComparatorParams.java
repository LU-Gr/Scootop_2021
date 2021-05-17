package com.projet.scootop.domain.services;

import com.projet.scootop.domain.configuration.CompetitionType;
import com.projet.scootop.domain.tools.Saison;
import com.projet.scootop.domain.tools.Team;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ComparatorParams {
	
	@Getter @Setter
	private Saison saison;
	
	@Getter @Setter
	private CompetitionType competitionType;
	
	@Getter @Setter
	private Team team;
	
	@Getter @Setter
	private Long playerAId;
	
	@Getter @Setter
	private Long playerBId;

}
