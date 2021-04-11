package com.projet.scootop.model.inprogress;

import java.util.List;

import com.projet.scootop.domain.domainconfiguration.Stade;
import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.domaintools.Competition;
import com.projet.scootop.domain.domaintools.Saison;
import com.projet.scootop.domain.domainuser.Scoot;
import com.projet.scootop.domain.inprogress.StatisticalSheet;
import com.projet.scootop.domain.services.Events;
import com.projet.scootop.domain.services.Wearable;

import lombok.Getter;
import lombok.Setter;

public class MatchSheetDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
	private Events event;
	
	@Getter @Setter
	private List<Team> team;
	
	@Getter @Setter
	private List<StatisticalSheet> statisticalSheets;
	
	@Getter @Setter
	private Stade stade;
	
	@Getter @Setter
	private List <Scoot> matchScoots;
	
	@Getter @Setter
	private List<Wearable> wearables;
	
	@Getter @Setter
	private Saison saison;
	
	@Getter @Setter
	private Competition competitionType;
}
