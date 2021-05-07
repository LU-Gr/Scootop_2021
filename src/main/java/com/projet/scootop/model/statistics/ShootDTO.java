package com.projet.scootop.model.statistics;

import com.projet.scootop.domain.user.domainuser.Player;
import com.projet.scootop.model.configuration.TouchTypeDTO;
import com.projet.scootop.model.tools.MatchDTO;

import lombok.Getter;
import lombok.Setter;

public class ShootDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private MatchDTO matchSheet;
	
	@Getter @Setter
	private TouchTypeDTO typeTouch;
	
	@Getter @Setter
	private Player player;
	
	@Getter @Setter
	private Boolean inBox;
	
	@Getter @Setter
	private Boolean isGoal;
	
	@Getter @Setter
	private Boolean isLongShoot;
	
	@Getter @Setter
	private PassDTO assist;

}
