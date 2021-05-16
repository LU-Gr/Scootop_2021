package com.projet.scootop.model.statistics;

import com.projet.scootop.model.configuration.ActionTypeDTO;
import com.projet.scootop.model.tools.MatchDTO;
import com.projet.scootop.model.tools.StatisticalSheetDTO;
import com.projet.scootop.model.user.domain.PlayerDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ActionDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private Boolean isDefensive;
	
	@Getter @Setter
	private Boolean successSkill;
	
	@Getter @Setter
	private Boolean isLong;
	
	@Getter @Setter
	private StatisticalSheetDTO statisticalSheet;
	
	@Getter @Setter
	private MatchDTO match;
	
	@Getter @Setter
	private PlayerDTO player;
	
	@Getter @Setter
    private ActionTypeDTO actionType;
}
