package com.projet.scootop.domain.domainuser;

import javax.persistence.Entity;

import com.projet.scootop.domain.domainconfiguration.Team;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Photo {
	
	@Getter @Setter
	private Player player;
	
	@Getter @Setter
	private Team team;
	
	@Getter @Setter
	private String url;

}
