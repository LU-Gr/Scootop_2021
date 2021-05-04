package com.projet.scootop.model.domainconfiguration;

import java.util.List;

import com.projet.scootop.model.domaintools.CompetitionDTO;
import com.projet.scootop.model.domaintools.SaisonDTO;
import com.projet.scootop.model.domainuser.ScootDTO;
import com.projet.scootop.model.services.EventsDTO;
import com.projet.scootop.model.services.WearableDTO;
import com.projet.scootop.model.statistical.StatisticalSheetDTO;

import lombok.Getter;
import lombok.Setter;

public class MatchSheetDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
	private EventsDTO event;
	
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
