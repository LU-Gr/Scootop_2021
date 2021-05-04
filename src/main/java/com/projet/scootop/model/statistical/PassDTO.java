package com.projet.scootop.model.statistical;

import java.time.LocalDate;

import com.projet.scootop.model.domainconfiguration.MatchSheetDTO;
import com.projet.scootop.model.domainuser.PlayerDTO;
import com.projet.scootop.model.statistical.physical.TypeTouchDTO;

import lombok.Getter;
import lombok.Setter;

public class PassDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
    private MatchSheetDTO matchSheet;
	
	@Getter @Setter
    private PlayerDTO player;
    
    @Getter @Setter
    private TypeTouchDTO typeTouch;
    
    @Getter @Setter
    private LocalDate date;
    
    @Getter @Setter
    private Boolean decisive;
    
    @Getter @Setter
    private Boolean successAssist;
    
    @Getter @Setter
    private Boolean longPass;

}
