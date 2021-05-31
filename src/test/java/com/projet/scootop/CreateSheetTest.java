package com.projet.scootop;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projet.scootop.domain.services.Event;
import com.projet.scootop.domain.statistics.Action;
import com.projet.scootop.domain.statistics.Goal;
import com.projet.scootop.domain.statistics.Pass;
import com.projet.scootop.domain.statistics.Shoot;
import com.projet.scootop.domain.tools.Match;
import com.projet.scootop.domain.tools.StatisticalSheet;
import com.projet.scootop.domain.user.domain.Player;


public class CreateSheetTest {
	
	@Test
	void testCreationSheet() throws JsonProcessingException {
		Match match = new Match();
		StatisticalSheet statisticalSheet = new StatisticalSheet();
		statisticalSheet.setMatch(match);
		match.getStatisticalSheetsTeamA().add(statisticalSheet);
		Shoot shoot = new Shoot();
		shoot.setMatch(match);
		Action action = new Action();
		action.setMatch(match);
		Pass pass = new Pass();
		pass.setMatch(match);
		Goal goal = new Goal();
		goal.setMatch(match);
		statisticalSheet.getShoots().add(shoot);
		statisticalSheet.getActions().add(action);
		statisticalSheet.getPasses().add(pass);
		statisticalSheet.getGoals().add(goal);
		shoot.setPass(pass);
		goal.setShoot(shoot);
		
		Player player = new Player();
		
		statisticalSheet.setPlayer(player);
		shoot.setPlayer(player);
		goal.setPlayer(player);
		pass.setPlayer(player);
		action.setPlayer(player);
		
		Event event = new Event();
		
		match.setEvent(event);
		
		statisticalSheet.setEvent(event);
		
		
		System.out.println("Stats: "+new ObjectMapper().writeValueAsString(statisticalSheet));
		System.out.println("Match: "+new ObjectMapper().writeValueAsString(match));
	}
}
