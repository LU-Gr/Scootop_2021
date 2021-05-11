package com.projet.scootop.model.services;


import java.util.List;

import com.projet.scootop.domain.user.User;
import com.projet.scootop.model.tools.TeamDTO;
import com.projet.scootop.model.user.domainuser.PlayerDTO;
import com.projet.scootop.model.user.domainuser.ScootDTO;

import lombok.Getter;
import lombok.Setter;

public class ShortlistDTO {
	
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private User user;
	
	@Getter @Setter
	private List <PlayerDTO> Players;
	
	@Getter @Setter
	private List <ScootDTO> Scoots;
	
	@Getter @Setter
	private List <TeamDTO> Teams;
	
	@Getter @Setter
	private int rank;
    
}
