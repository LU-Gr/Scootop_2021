package com.projet.scootop.model.services;

import java.util.List;

import com.projet.scootop.model.domainconfiguration.TeamDTO;
import com.projet.scootop.model.domaintools.CompetitionDTO;
import com.projet.scootop.model.domaintools.SaisonDTO;
import com.projet.scootop.model.domainuser.PlayerDTO;
import com.projet.scootop.model.inprogress.StatisticalSheetDTO;

import lombok.Getter;
import lombok.Setter;

public class UserResumeDTO {

	@Getter @Setter
    private Long id;
	
	@Getter @Setter
	private PlayerDTO player;
    
    @Getter @Setter
    private CompetitionDTO competitionType;
    
    @Getter @Setter
    private List<StatisticalSheetDTO> statisticalSheets;
    
    @Getter @Setter
    private List<SaisonDTO> saisons;
    
    @Getter @Setter
    private List<TeamDTO> teams;

}
