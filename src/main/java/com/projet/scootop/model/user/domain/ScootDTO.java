package com.projet.scootop.model.user.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.model.services.ShortlistDTO;
import com.projet.scootop.model.tools.ClubDTO;
import com.projet.scootop.model.user.UserDTO;

import lombok.Getter;
import lombok.Setter;

public class ScootDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
    private UserDTO user;
	
	@Getter @Setter
	 @JsonIgnoreProperties({"scoots","user"})
    private ShortlistDTO shortlist;
	
	@Getter @Setter
    private List<ClubDTO> clubs;
	
	@Getter @Setter
    private List<ShortlistDTO> followedShortlists;

}
