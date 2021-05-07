package com.projet.scootop.model.statistics;

import com.projet.scootop.domain.tools.Match;
import com.projet.scootop.domain.user.domainuser.Player;
import com.projet.scootop.model.tools.MatchDTO;
import com.projet.scootop.model.user.domainuser.PlayerDTO;

import lombok.Getter;
import lombok.Setter;

public class ActionDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private MatchDTO matchSheet;
	
	@Getter @Setter
	private PlayerDTO player;
	
	@Getter @Setter
	private Boolean isDefensive;
	
	@Getter @Setter
	private Boolean successSkill;
	
	@Getter @Setter
	private Boolean isLong;

}
