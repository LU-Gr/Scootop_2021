package com.projet.scootop.model.inprogress;

import java.util.List;

import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.inprogress.MatchSheet;
import com.projet.scootop.domain.services.Events;
import com.projet.scootop.domain.statistical.Action;
import com.projet.scootop.domain.statistical.Goal;
import com.projet.scootop.domain.statistical.Pass;
import com.projet.scootop.domain.statistical.Shoot;
import com.projet.scootop.domain.statistical.physical.PlayerHead;

import lombok.Getter;
import lombok.Setter;

public class StatisticalSheetDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
    private MatchSheet matchSheet;
	
	@Getter @Setter
    private List<Player> players;
	
	@Getter @Setter
    private Events events;
	
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
    private List<Shoot> Shoots;
    
    @Getter @Setter
    private List<PlayerHead> Heads;
    
    @Getter @Setter
    private List<Pass> assists;
    
    @Getter @Setter
    private List<Action> skills;
    
    @Getter @Setter
    private List<Goal> goals;
    
    @Getter @Setter
    private float distancekm;

}
