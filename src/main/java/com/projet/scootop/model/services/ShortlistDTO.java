package com.projet.scootop.model.services;


import java.util.List;

import com.projet.scootop.model.tools.TeamDTO;
import com.projet.scootop.model.user.UserDTO;
import com.projet.scootop.model.user.domain.PlayerDTO;
import com.projet.scootop.model.user.domain.ScootDTO;

import lombok.Getter;
import lombok.Setter;

public class ShortlistDTO {
	
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private int rank;
	
	@Getter @Setter
	private UserDTO user;
	
	@Getter @Setter
	private List <PlayerDTO> Players;
	
	@Getter @Setter
	private List <ScootDTO> Scoots;
	
	@Getter @Setter
	private List <TeamDTO> Teams;
	
	
    
}
