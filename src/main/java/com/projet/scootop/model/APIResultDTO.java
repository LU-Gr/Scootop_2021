package com.projet.scootop.model;

import lombok.Getter;
import lombok.Setter;

public class APIResultDTO {
	
	@Getter @Setter
	private String message;
	
	@Getter @Setter
	private String error;

	public APIResultDTO(String message, String error) {
		super();
		this.message = message;
		this.error = error;
	}

	
}
