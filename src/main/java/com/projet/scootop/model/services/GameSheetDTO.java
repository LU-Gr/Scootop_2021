package com.projet.scootop.model.services;

import java.util.Date;
import java.util.List;

import com.projet.scootop.model.domainconfiguration.StadeDTO;
import com.projet.scootop.model.domainconfiguration.TeamDTO;
import com.projet.scootop.model.inprogress.StatisticalSheetDTO;
import com.projet.scootop.model.user.UserDTO;

import lombok.Getter;
import lombok.Setter;

public class GameSheetDTO {
	
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private UserDTO user;
	
	@Getter @Setter
	private List<TeamDTO> teams;
    
    @Getter @Setter
    private List<StatisticalSheetDTO> stactisticalSheets;
    
    @Getter @Setter
    private StadeDTO stade;
    
    @Getter @Setter
    private EventsDTO events;
    
    @Getter @Setter
    private Date date;

}
