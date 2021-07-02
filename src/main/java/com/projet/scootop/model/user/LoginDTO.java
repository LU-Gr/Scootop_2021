package com.projet.scootop.model.user;

import lombok.Getter;
import lombok.Setter;

public class LoginDTO {

	@Getter @Setter
	private Integer code;
	
	@Getter @Setter
	private String message;
	
	@Getter @Setter
	private String jwt;
	
	@Getter @Setter
	private String refreshToken;
	
	@Getter @Setter
	private UserDTO user;
}
