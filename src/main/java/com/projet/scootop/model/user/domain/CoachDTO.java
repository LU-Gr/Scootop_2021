package com.projet.scootop.model.user.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.model.tools.TeamDTO;
import com.projet.scootop.model.user.UserDTO;

public class CoachDTO {

	@Getter @Setter
    private Long id;
	
	@Getter @Setter
    private UserDTO user;

	@Getter @Setter
	@JsonIgnoreProperties("coaches")
    private List<TeamDTO> teams;
}
