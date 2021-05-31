package com.projet.scootop.model.tools;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.model.services.EventDTO;
import com.projet.scootop.model.statistics.ActionDTO;
import com.projet.scootop.model.statistics.GoalDTO;
import com.projet.scootop.model.statistics.PassDTO;
import com.projet.scootop.model.statistics.ShootDTO;
import com.projet.scootop.model.user.domain.PlayerDTO;

import lombok.Getter;
import lombok.Setter;

public class StatisticalSheetDTO {
	
	@Getter @Setter
    private Long id;	

	@Getter @Setter
    private int nbBallplayed;
	
	@Getter @Setter
    private int nbBalllost;
    
    @Getter @Setter
    private int nbBallSuccess;
    
    @Getter @Setter
    private float distancekm;
    
    @Getter @Setter
    @JsonIgnoreProperties({"statisticalSheetsTeamA","statisticalSheetsTeamB","event"})
    private MatchDTO match;
    
    @Getter @Setter
    private EventDTO event;
	
	@Getter @Setter
	@JsonIgnoreProperties({"statisticalSheets","teams"})
    private PlayerDTO player;
	
	@Getter @Setter
	@JsonIgnoreProperties("players")
    private TeamDTO team;
    
    @Getter @Setter
    @JsonIgnoreProperties({"match", "player"})
    private List<ShootDTO> Shoots;
    
    @Getter @Setter
    @JsonIgnoreProperties({"match", "player"})
    private List<PassDTO> passes;
    
    @Getter @Setter
    @JsonIgnoreProperties({"match", "player"})
    private List<ActionDTO> actions;
    
    @Getter @Setter
    @JsonIgnoreProperties({"match", "player"})
    private List<GoalDTO> goals;
    
   

}
