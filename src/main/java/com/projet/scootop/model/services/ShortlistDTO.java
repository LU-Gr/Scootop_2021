package com.projet.scootop.model.services;


import java.util.List;

import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.domainuser.Player;
import com.projet.scootop.domain.user.domainuser.Scoot;

import lombok.Getter;
import lombok.Setter;

public class ShortlistDTO {
	
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private User user;
	
	@Getter @Setter
	private List <Player> Players;
	
	@Getter @Setter
	private List <Scoot> Scoots;
	
	@Getter @Setter
	private List <Team> Teams;
	
	@Getter @Setter
	private int rank;
    
}
