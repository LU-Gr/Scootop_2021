package com.projet.scootop.model.user.domainuser;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.projet.scootop.model.tools.TeamDTO;
import com.projet.scootop.model.user.UserDTO;

public class CoachDTO {

	@Getter @Setter
    private Long id;
	
	@Getter @Setter
    private UserDTO user;

	@Getter @Setter
    private List<TeamDTO> teams;
}
