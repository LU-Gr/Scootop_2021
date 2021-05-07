package com.projet.scootop.model.statistics;

import java.time.LocalDate;

import com.projet.scootop.model.configuration.TouchTypeDTO;
import com.projet.scootop.model.tools.MatchDTO;
import com.projet.scootop.model.user.domainuser.PlayerDTO;

import lombok.Getter;
import lombok.Setter;

public class PassDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
    private MatchDTO matchSheet;
	
	@Getter @Setter
    private PlayerDTO player;
    
    @Getter @Setter
    private TouchTypeDTO typeTouch;
    
    @Getter @Setter
    private LocalDate date;
    
    @Getter @Setter
    private Boolean decisive;
    
    @Getter @Setter
    private Boolean successAssist;
    
    @Getter @Setter
    private Boolean longPass;

}
