package com.projet.scootop.model.statistical;

import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.inprogress.MatchSheet;
import com.projet.scootop.domain.statistical.Pass;
import com.projet.scootop.domain.statistical.physical.TypeTouch;

import lombok.Getter;
import lombok.Setter;

public class ShootDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private MatchSheet matchSheet;
	
	@Getter @Setter
	private TypeTouch typeTouch;
	
	@Getter @Setter
	private Player player;
	
	@Getter @Setter
	private Boolean inBox;
	
	@Getter @Setter
	private Boolean isGoal;
	
	@Getter @Setter
	private Boolean isLongShoot;
	
	@Getter @Setter
	private Pass assist;

}
