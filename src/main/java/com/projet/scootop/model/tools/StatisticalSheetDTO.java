package com.projet.scootop.model.tools;

import java.util.List;

import com.projet.scootop.model.services.EventDTO;
import com.projet.scootop.model.statistics.ActionDTO;
import com.projet.scootop.model.statistics.GoalDTO;
import com.projet.scootop.model.statistics.PassDTO;
import com.projet.scootop.model.statistics.ShootDTO;
import com.projet.scootop.model.user.domainuser.PlayerDTO;

import lombok.Getter;
import lombok.Setter;

public class StatisticalSheetDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
    private MatchDTO matchSheet;
	
	@Getter @Setter
    private PlayerDTO player;
	
	@Getter @Setter
    private EventDTO events;

	@Getter @Setter
    private int nbBballplayed;
	
	@Getter @Setter
    private int nbBalllost;
    
    @Getter @Setter
    private int nbBallSuccess;
    
    @Getter @Setter
    private List<ShootDTO> Shoots;
    
    @Getter @Setter
    private List<PassDTO> assists;
    
    @Getter @Setter
    private List<ActionDTO> skills;
    
    @Getter @Setter
    private List<GoalDTO> goals;
    
    @Getter @Setter
    private float distancekm;

}
