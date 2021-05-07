package com.projet.scootop.model.services;

import com.projet.scootop.model.user.ContactDTO;

import lombok.Getter;
import lombok.Setter;

public class WearableCompanyDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
	private String societe;
	
	@Getter @Setter
	private String ceo;
	
	@Getter @Setter
	private String specialite;
	
	@Getter @Setter
	private Integer tarif;
	
	@Getter @Setter
	private ContactDTO contact;
}
