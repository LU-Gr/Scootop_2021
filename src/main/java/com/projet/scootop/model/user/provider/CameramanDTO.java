package com.projet.scootop.model.user.provider;

import com.projet.scootop.model.user.UserDTO;

import lombok.Getter;
import lombok.Setter;

public class CameramanDTO {

	@Getter @Setter
    private Long id;
	
	@Getter @Setter
	private Double tarif;
	
	@Getter @Setter
	private Integer experience;
	
	@Getter @Setter
	private UserDTO user;

}
