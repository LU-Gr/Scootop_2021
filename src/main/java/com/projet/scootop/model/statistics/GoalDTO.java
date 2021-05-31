package com.projet.scootop.model.statistics;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.model.tools.MatchDTO;
import com.projet.scootop.model.user.domain.PlayerDTO;

import lombok.Getter;
import lombok.Setter;

public class GoalDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private LocalDate date;
	
	@Getter @Setter
	private Integer rating;
	
	@Getter @Setter
	@JsonIgnoreProperties({"match"})
	private ShootDTO shoot;
	
	@Getter @Setter
	@JsonIgnoreProperties({"statisticalSheetsTeamA","statisticalSheetsTeamB"})
    private MatchDTO match;
	
	@Getter @Setter
    private PlayerDTO player;

}
