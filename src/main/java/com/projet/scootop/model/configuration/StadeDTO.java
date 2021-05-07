package com.projet.scootop.model.configuration;

import com.projet.scootop.model.user.ContactDTO;

import lombok.Getter;
import lombok.Setter;

public class StadeDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private ContactDTO contact;
}
