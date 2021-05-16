package com.projet.scootop.model.statistics;

import com.projet.scootop.model.configuration.TouchTypeDTO;
import com.projet.scootop.model.tools.MatchDTO;
import com.projet.scootop.model.tools.StatisticalSheetDTO;
import com.projet.scootop.model.user.domain.PlayerDTO;

import lombok.Getter;
import lombok.Setter;

public class PassDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private int minute;
	
	@Getter @Setter
    private Boolean decisive;
    
    @Getter @Setter
    private Boolean isSuccess;
    
    @Getter @Setter
    private Boolean isLongPass;
    
    @Getter @Setter
	private StatisticalSheetDTO statisticalSheet;
	
	@Getter @Setter
    private MatchDTO match;
	
	@Getter @Setter
    private PlayerDTO player;
    
    @Getter @Setter
    private TouchTypeDTO touchType;

}
