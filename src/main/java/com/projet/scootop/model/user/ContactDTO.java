package com.projet.scootop.model.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ContactDTO {

	@Getter @Setter
    private Long id;
	
	@Getter @Setter
	private String email;
	
	@Getter @Setter
	private String tel;
	
	@Getter @Setter
	private String address;
	
	@Getter @Setter
    private String ville;
	
	@Getter @Setter
    private String codePostal;

}
