package com.projet.scootop.model.services;

import com.projet.scootop.model.domainconfiguration.TeamDTO;
import com.projet.scootop.model.domainuser.PlayerDTO;
import com.projet.scootop.model.inprogress.MatchSheetDTO;

import lombok.Getter;
import lombok.Setter;

public class WearableDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private PlayerDTO player;
	
	@Getter @Setter
	private TeamDTO team;
	
	@Getter @Setter
	private MatchSheetDTO matchSheet;
	
	@Getter @Setter
	private Integer distanceRun;
	
	@Getter @Setter
	private Integer distancePlay;
	
	@Getter @Setter
	private Integer vMax;
	
	@Getter @Setter
	private Integer vMaxWithBall;
	
	@Getter @Setter
	private Integer ballPlay;
	
	@Getter @Setter
	private Integer looseBall;
	
	@Getter @Setter
	private Integer ballRecovered;
	
	@Getter @Setter
	private Integer tackle;
	
	@Getter @Setter
	private Integer foulSuffered;
	
	@Getter @Setter
	private Integer failPass;
	
	@Getter @Setter
	private Integer assist;
	
	@Getter @Setter
	private Integer shortPass;
	
	@Getter @Setter
	private Integer head;
	
	@Getter @Setter
	private Integer headOffensive;
	
	@Getter @Setter
	private Integer headDefensive;
	
	@Getter @Setter
    private Integer shots;
	
	@Getter @Setter
    private Integer shotOnTarget;
    
    @Getter @Setter
    private Integer shotOffTarget;
    
    @Getter @Setter
    private Integer longShot;
    
    @Getter @Setter
    private Integer successSkill;
    
    @Getter @Setter
    private Integer failSkill;


}
