package com.projet.scootop.model.services;

import java.time.LocalDate;
import java.util.List;

import com.projet.scootop.model.domainconfiguration.TeamDTO;
import com.projet.scootop.model.domaintools.CompetitionDTO;
import com.projet.scootop.model.domaintools.SaisonDTO;
import com.projet.scootop.model.domainuser.ScootDTO;
import com.projet.scootop.model.servicetools.video.VideoDTO;

import lombok.Getter;
import lombok.Setter;

public class EventsDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private LocalDate date;
	
	@Getter @Setter
	private CompetitionDTO competitiontype;
	
	@Getter @Setter
	private List <TeamDTO> teams;
	
	@Getter @Setter
	private List <ScootDTO> scoots;
	
	@Getter @Setter
	private boolean status;
	
	@Getter @Setter
	private boolean prestaAnalyst;
	
	@Getter @Setter
	private boolean prestaCameraman;
	
	@Getter @Setter
    private boolean prestaWearable;
	
	@Getter @Setter
    private boolean prestaScoot;
    
    @Getter @Setter
    private boolean prestaZoom;
    
    @Getter @Setter
    private SaisonDTO saison;
    
    @Getter @Setter
    private List<VideoDTO> videos;

}
