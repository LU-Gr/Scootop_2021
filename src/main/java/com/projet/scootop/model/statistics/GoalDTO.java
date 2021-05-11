package com.projet.scootop.model.statistics;

import java.time.LocalDate;

import com.projet.scootop.model.tools.MatchDTO;
import com.projet.scootop.model.user.domainuser.PlayerDTO;

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
	private ShootDTO shoot;
	
	@Getter @Setter
    private MatchDTO match;
	
	@Getter @Setter
    private PlayerDTO player;

}
