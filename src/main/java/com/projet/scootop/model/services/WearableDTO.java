package com.projet.scootop.model.services;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class WearableDTO {

	@Getter @Setter
	private Long id;
	
    @Getter @Setter
    private String identifiant;
    
    @Getter @Setter
    private List<LocationWearableDTO> locations;


}
