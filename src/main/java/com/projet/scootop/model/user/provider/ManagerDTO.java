package com.projet.scootop.model.user.provider;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.model.user.UserDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ManagerDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private UserDTO user;
	
	@Getter @Setter
	@JsonIgnoreProperties("managers")
	private AgenceDTO agence;
}
