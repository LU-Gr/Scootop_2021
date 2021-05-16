package com.projet.scootop.model.tools;

import java.util.List;

import com.projet.scootop.model.configuration.StadeDTO;
import com.projet.scootop.model.services.EventDTO;
import com.projet.scootop.model.services.LocationWearableDTO;
import com.projet.scootop.model.user.domain.ScootDTO;

import lombok.Getter;
import lombok.Setter;

public class MatchDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
	private EventDTO event;
	
	@Getter @Setter
	private CompetitionDTO competition;
	
    @Getter @Setter
    private TeamDTO teamA;
    
    @Getter @Setter
    private TeamDTO teamB;
	
	@Getter @Setter
	private StadeDTO stade;
	
	@Getter @Setter
	private SaisonDTO saison;
	
	@Getter @Setter
	private List<StatisticalSheetDTO> statisticalSheetsTeamB;
	
    @Getter @Setter
    private List<StatisticalSheetDTO> statisticalSheetsTeamA;
	
	@Getter @Setter
	private List <ScootDTO> scoots;
	
	@Getter @Setter
	private List<LocationWearableDTO> wearables;
	
	
	
}
