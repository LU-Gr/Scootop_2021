package com.projet.scootop.model.user.domain;

import lombok.Getter;
import lombok.Setter;

public class PlayerSearchListDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
    private String firstName;
	
	@Getter @Setter
    private String lastName;
	
	@Getter @Setter
    private String photoUrl;

}
