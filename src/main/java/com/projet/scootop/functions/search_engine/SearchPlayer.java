package com.projet.scootop.functions.search_engine;

import java.util.List;

import com.projet.scootop.domain.configuration.Poste;
import com.projet.scootop.domain.tools.Team;

import lombok.Getter;
import lombok.ToString;

@ToString
public class SearchPlayer {
	
	@Getter
	private String name;
	
	@Getter
	List<Poste> postes;
	
	@Getter
	Team team;

}
