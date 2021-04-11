package com.projet.scootop.model.domainuser;

import java.util.List;

import com.projet.scootop.model.domainconfiguration.ClubDTO;
import com.projet.scootop.model.services.ShortlistDTO;
import com.projet.scootop.model.user.UserDTO;

import lombok.Getter;
import lombok.Setter;

public class ScootDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
    private UserDTO user;
	
	@Getter @Setter
    private ShortlistDTO shortlist;
	
	@Getter @Setter
    private List<ClubDTO> clubs;
	
	

}