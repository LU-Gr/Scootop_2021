package com.projet.scootop.model.statistical;

import java.util.List;

import com.projet.scootop.domain.domainconfiguration.MatchSheet;
import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.services.Event;
import com.projet.scootop.domain.statistical.Action;
import com.projet.scootop.domain.statistical.Goal;
import com.projet.scootop.domain.statistical.Pass;
import com.projet.scootop.domain.statistical.Shoot;
import com.projet.scootop.domain.statistical.physical.PlayerHead;
import com.projet.scootop.model.domainconfiguration.MatchSheetDTO;
import com.projet.scootop.model.domainuser.PlayerDTO;
import com.projet.scootop.model.services.EventsDTO;
import com.projet.scootop.model.statistical.physical.PlayerHeadDTO;

import lombok.Getter;
import lombok.Setter;

public class StatisticalSheetDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
    private MatchSheetDTO matchSheet;
	
	@Getter @Setter
    private List<PlayerDTO> players;
	
	@Getter @Setter
    private EventsDTO events;
	
	@Getter @Setter
    private int nbShootIn;
	
	@Getter @Setter
    private int nbShootOut;
	
	@Getter @Setter
    private int nbBballplayed;
	
	@Getter @Setter
    private int nbBalllost;
    
    @Getter @Setter
    private int nbBallSuccess;
    
    @Getter @Setter
    private int nbDefensiveSkills;
    
    @Getter @Setter
    private int nbOffensiveSkills;
    
    @Getter @Setter
    private List<ShootDTO> Shoots;
    
    @Getter @Setter
    private List<PlayerHeadDTO> Heads;
    
    @Getter @Setter
    private List<PassDTO> assists;
    
    @Getter @Setter
    private List<ActionDTO> skills;
    
    @Getter @Setter
    private List<GoalDTO> goals;
    
    @Getter @Setter
    private float distancekm;

}
