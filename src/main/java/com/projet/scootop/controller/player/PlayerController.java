package com.projet.scootop.controller.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.scootop.model.tools.StatisticalSheetDTO;
import com.projet.scootop.model.user.domain.FicheJoueurDTO;
import com.projet.scootop.model.user.domain.PlayerDTO;
import com.projet.scootop.service.tools.StatisticalSheetService;
import com.projet.scootop.service.user.domain.PlayerService;


@RestController
@RequestMapping("/player")
public class PlayerController {
	
	@Autowired PlayerService playerService;
	@Autowired StatisticalSheetService ssService;
	
	@GetMapping("/players")
	List<PlayerDTO> getAllPlayers(){
		return playerService.getAll();
	}
	
	@GetMapping("/player/{id}")
	PlayerDTO getPlayer(@PathVariable Long id){
		return playerService.get(id);
	}
	
	@PostMapping("/player")
	PlayerDTO addPlayer(@RequestBody PlayerDTO player) {
		return playerService.add(player);
	}
	
	@GetMapping("/player/fiche")
	FicheJoueurDTO getFicheJoueur(@RequestBody FicheJoueurDTO params) {
		return playerService.getFicheJoueur(params);
	}
	
	StatisticalSheetDTO getPlayerStats(@PathVariable Long id) {
		return ssService.get(id);
	}

}
