package com.projet.scootop.model.statistical.physical;

import com.projet.scootop.model.domainuser.PlayerDTO;
import lombok.Getter;
import lombok.Setter;


public class PlayerHeadDTO {

	@Getter @Setter
    private Integer id;
	
	@Getter @Setter
	private PlayerDTO player;

}
