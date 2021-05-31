package com.projet.scootop.model.statistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.model.configuration.TouchTypeDTO;
import com.projet.scootop.model.tools.MatchDTO;
import com.projet.scootop.model.user.domain.PlayerDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ShootDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
    private int minute;
	
	@Getter @Setter
    private Boolean isFreeKick;
    
    @Getter @Setter
    private Boolean isPenaltyBox;
    
    @Getter @Setter
    private Boolean isGoal;
    
    @Getter @Setter
    private Boolean isLongShoot;
    
    @Getter @Setter
    private Boolean isInBox;
	
	@Getter @Setter
	@JsonIgnoreProperties({"match"})
	private PassDTO pass;
	
	@Getter @Setter
	@JsonIgnoreProperties({"statisticalSheetsTeamA","statisticalSheetsTeamB"})
	private MatchDTO match;
	
	@Getter @Setter
	private TouchTypeDTO touchType;
	
	@Getter @Setter
	private PlayerDTO player;
}
