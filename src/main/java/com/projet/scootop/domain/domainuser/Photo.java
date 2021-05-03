package com.projet.scootop.domain.domainuser;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.projet.scootop.domain.domainconfiguration.Team;

import lombok.Getter;
import lombok.Setter;

public class Photo {
	
	@Getter @Setter
	private Player player;
	
	@Getter @Setter
	private Team team;
	
	@Getter @Setter
	private String url;

}
