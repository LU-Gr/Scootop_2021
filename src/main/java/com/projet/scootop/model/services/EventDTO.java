package com.projet.scootop.model.services;

import java.time.LocalDate;
import java.util.List;

import com.projet.scootop.model.services.tools.video.VideoDTO;
import com.projet.scootop.model.tools.CompetitionDTO;
import com.projet.scootop.model.tools.SaisonDTO;
import com.projet.scootop.model.tools.TeamDTO;
import com.projet.scootop.model.user.domain.ScootDTO;
import com.projet.scootop.model.user.provider.AnalysteDTO;
import com.projet.scootop.model.user.provider.CameramanDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class EventDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private LocalDate date;
	
	@Getter @Setter
	private boolean status;
	
	@Getter @Setter
    private boolean prestaWearable;
	
    @Getter @Setter
    private boolean prestaZoom;
    
    @Getter @Setter
    private List<VideoDTO> videos;
	
	@Getter @Setter
	private CompetitionDTO competition;
	
	@Getter @Setter
	private SaisonDTO saison;
	
	@Getter @Setter
	private List <TeamDTO> teams;
	
	@Getter @Setter
	private List <ScootDTO> scoots;
	
	@Getter @Setter
    private List<AnalysteDTO> analysts;
    
    @Getter @Setter
    private List<CameramanDTO> cameramans;
}
