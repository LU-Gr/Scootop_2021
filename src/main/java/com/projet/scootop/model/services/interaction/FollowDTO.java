package com.projet.scootop.model.services.interaction;


import java.time.LocalDate;

import com.projet.scootop.model.tools.SaisonDTO;
import com.projet.scootop.model.user.UserDTO;
import com.projet.scootop.model.user.domainuser.PlayerDTO;

import lombok.Getter;
import lombok.Setter;

public class FollowDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private LocalDate dateCreated;
	
	@Getter @Setter
	private UserDTO user;
	
	@Getter @Setter
	private PlayerDTO player;
	
	@Getter @Setter
	private SaisonDTO saison;

}
