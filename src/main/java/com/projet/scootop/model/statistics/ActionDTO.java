package com.projet.scootop.model.statistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.model.configuration.ActionTypeDTO;
import com.projet.scootop.model.tools.MatchDTO;
import com.projet.scootop.model.user.domain.PlayerDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ActionDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private int minute;
	
	@Getter @Setter
	private Boolean isDefensive;
	
	@Getter @Setter
	private Boolean isSuccessful;
	
	@Getter @Setter
    private ActionTypeDTO actionType;
	
	@Getter @Setter
	@JsonIgnoreProperties({"statisticalSheetsTeamA","statisticalSheetsTeamB"})
	private MatchDTO match;
	
	@Getter @Setter
	private PlayerDTO player;
	
	
}
