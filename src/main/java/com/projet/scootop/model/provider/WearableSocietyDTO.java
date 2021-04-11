package com.projet.scootop.model.provider;

import com.projet.scootop.model.user.ContactDTO;

import lombok.Getter;
import lombok.Setter;

public class WearableSocietyDTO {
	
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
