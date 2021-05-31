package com.projet.scootop;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projet.scootop.domain.configuration.Poste;
import com.projet.scootop.domain.services.tools.video.Video;
import com.projet.scootop.domain.tools.Club;
import com.projet.scootop.domain.tools.StatisticalSheet;
import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.domain.Player;
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
		Video video = new Video();
		video.setPlayer(player);
		player.getVideos().add(video);
		
		Club club = new Club();
		
		team.setClub(club);
		club.getTeams().add(team);
		
		PlayerDTO dto = new PlayerDTO();
		
		ObjectMapper o = new ObjectMapper();
		dto = o.readValue(new ObjectMapper().writeValueAsString(player), PlayerDTO.class);
		
		
		System.out.println("Player: "+new ObjectMapper().writeValueAsString(player));
		System.out.println("DTO: "+ new ObjectMapper().writeValueAsString(dto));
		/*System.out.println("Stats: "+new ObjectMapper().writeValueAsString(ss));
		System.out.println("Team: "+new ObjectMapper().writeValueAsString(team));
		System.out.println("Club: "+new ObjectMapper().writeValueAsString(club));
		System.out.println("Poste: "+new ObjectMapper().writeValueAsString(poste));
		System.out.println("Video: "+new ObjectMapper().writeValueAsString(video));*/
		
	}

}
