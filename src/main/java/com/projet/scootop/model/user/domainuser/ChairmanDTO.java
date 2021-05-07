package com.projet.scootop.model.user.domainuser;

import com.projet.scootop.model.user.UserDTO;

import lombok.Getter;
import lombok.Setter;

public class ChairmanDTO {

	@Getter @Setter
    private Long id;
	
	@Getter @Setter
    private UserDTO user;
}
