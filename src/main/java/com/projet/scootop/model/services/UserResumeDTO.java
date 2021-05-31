package com.projet.scootop.model.services;

import java.util.List;

import com.projet.scootop.model.tools.CompetitionDTO;
import com.projet.scootop.model.tools.SaisonDTO;
import com.projet.scootop.model.tools.StatisticalSheetDTO;
import com.projet.scootop.model.tools.TeamDTO;
import com.projet.scootop.model.user.domain.PlayerDTO;

import lombok.Getter;
import lombok.Setter;

public class UserResumeDTO {

	@Getter @Setter
    private Long id;
	
	@Getter @Setter
	private int rank;

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
