package com.projet.scootop.model.user.provider;

import lombok.Getter;
import lombok.Setter;

public class ManagerDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private AgenceDTO agence;
}
