package com.projet.scootop.model.tools;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.model.user.ContactDTO;
import com.projet.scootop.model.user.domain.ScootDTO;

@ToString
public class ClubDTO {
	
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
    private String colorInside;
	
	@Getter @Setter
	private String colorOutSide;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private ContactDTO contact;
	
	@Getter @Setter
	@JsonIgnoreProperties({"club"})
	private List<TeamDTO> teams;
	
	@Getter @Setter
	private List<ScootDTO> scoots;
	
}
