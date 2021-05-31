package com.projet.scootop.model.user;

import lombok.Getter;
import lombok.Setter;

public class ContactDTO {

	@Getter @Setter
    private Long id;
	
	@Getter @Setter
	private String tel;
	
	@Getter @Setter
	private String address;
	
	@Getter @Setter
    private String codePostal;

	@Getter @Setter
    private String ville;
	
	@Getter @Setter
	private String pays;

}
