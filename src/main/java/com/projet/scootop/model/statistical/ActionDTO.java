package com.projet.scootop.model.statistical;

import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.inprogress.MatchSheet;
import com.projet.scootop.model.domainuser.PlayerDTO;
import com.projet.scootop.model.inprogress.MatchSheetDTO;

import lombok.Getter;
import lombok.Setter;

public class ActionDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private MatchSheetDTO matchSheet;
	
	@Getter @Setter
	private PlayerDTO player;
	
	@Getter @Setter
	private Boolean isDefensive;
	
	@Getter @Setter
	private Boolean successSkill;
	
	@Getter @Setter
	private Boolean isLong;

}
