package com.projet.scootop.controller.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.projet.scootop.model.inprogress.StatisticalSheetDTO;
import com.projet.scootop.service.domainuser.PlayerService;
import com.projet.scootop.service.inprogess.StatisticalSheetService;

@RestController
public class PlayerController {
	
	@Autowired PlayerService playerService;
	@Autowired StatisticalSheetService ssService;
	
	StatisticalSheetDTO getPlayerStats(@PathVariable Long id) {
		return ssService.get(id);
	}

}
