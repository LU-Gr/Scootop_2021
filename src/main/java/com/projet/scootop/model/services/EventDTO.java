package com.projet.scootop.model.services;

import java.time.LocalDate;
import java.util.List;

import com.projet.scootop.model.services.tools.video.VideoDTO;
import com.projet.scootop.model.tools.CompetitionDTO;
import com.projet.scootop.model.tools.SaisonDTO;
import com.projet.scootop.model.tools.TeamDTO;
import com.projet.scootop.model.user.domainuser.ScootDTO;

import lombok.Getter;
import lombok.Setter;

public class EventDTO {

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
