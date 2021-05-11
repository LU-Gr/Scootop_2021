package com.projet.scootop.model.user.provider;

import com.projet.scootop.model.user.UserDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ManagerDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private UserDTO user;
	
	@Getter @Setter
	private AgenceDTO agence;
}
