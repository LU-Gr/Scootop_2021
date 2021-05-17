package com.projet.scootop;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projet.scootop.domain.configuration.Poste;
import com.projet.scootop.domain.tools.StatisticalSheet;
import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.domain.Player;
import com.projet.scootop.mappers.user.domain.PlayerMapper;
import com.projet.scootop.model.user.domain.PlayerDTO;

class CreatePlayerTest {

	@Test
	void testCreationPlayer() throws JsonProcessingException {
		User user = new User();
		user.setFirstName("Adrien");
		Player player = new Player();
		player.setUser(user);
		StatisticalSheet ss = new StatisticalSheet();
		ss.setId(1l);
		ss.setNbBallplayed(10);
		ss.setPlayer(player);
		player.getStatisticalSheets().add(ss);
		Team team = new Team();
		team.getPlayers().add(player);
		player.getTeams().add(team);
		ss.setTeam(team);
		Poste poste = new Poste();
		poste.setName("Attaquant");
		poste.getPlayers().add(player);
		player.getPostes().add(poste);
		
		
		System.out.println("Player: "+new ObjectMapper().writeValueAsString(player));
		System.out.println("Stats: "+new ObjectMapper().writeValueAsString(ss));
		System.out.println("Team: "+new ObjectMapper().writeValueAsString(team));
		System.out.println("Poste: "+new ObjectMapper().writeValueAsString(poste));
	}

}
