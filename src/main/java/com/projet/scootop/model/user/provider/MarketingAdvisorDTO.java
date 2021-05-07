package com.projet.scootop.model.user.provider;

import com.projet.scootop.model.user.UserDTO;

import lombok.Getter;
import lombok.Setter;

public class MarketingAdvisorDTO {
	
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private UserDTO user;
	
	@Getter @Setter
	private AgenceDTO agence;

}
