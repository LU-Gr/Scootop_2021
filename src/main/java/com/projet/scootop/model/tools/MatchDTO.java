package com.projet.scootop.model.tools;

import java.util.List;

import com.projet.scootop.model.configuration.StadeDTO;
import com.projet.scootop.model.services.EventDTO;
import com.projet.scootop.model.services.WearableDTO;
import com.projet.scootop.model.user.domainuser.ScootDTO;

import lombok.Getter;
import lombok.Setter;

public class MatchDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
	private EventDTO event;
	
    @Getter @Setter
    private TeamDTO team1;
    
    @Getter @Setter
    private TeamDTO team2;
	
	@Getter @Setter
	private List<StatisticalSheetDTO> statisticalSheets;
	
	@Getter @Setter
	private StadeDTO stade;
	
	@Getter @Setter
	private List <ScootDTO> matchScoots;
	
	@Getter @Setter
	private List<WearableDTO> wearables;
	
	@Getter @Setter
	private SaisonDTO saison;
	
	@Getter @Setter
	private CompetitionDTO competitionType;
}
