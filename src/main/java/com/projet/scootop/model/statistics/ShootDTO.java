package com.projet.scootop.model.statistics;

import com.projet.scootop.model.configuration.TouchTypeDTO;
import com.projet.scootop.model.tools.MatchDTO;
import com.projet.scootop.model.tools.StatisticalSheetDTO;
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
	private PassDTO pass;
	
	@Getter @Setter
	private StatisticalSheetDTO statisticalSheet;
	
	@Getter @Setter
	private MatchDTO match;
	
	@Getter @Setter
	private TouchTypeDTO touchType;
	
	@Getter @Setter
	private PlayerDTO player;
}
