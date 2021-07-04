package com.projet.scootop.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.projet.scootop.functions.search_engine.SearchPlayer;
import com.projet.scootop.model.services.ComparatorParamsDTO;
import com.projet.scootop.model.user.domain.ChairmanDTO;
import com.projet.scootop.model.user.domain.CoachDTO;
import com.projet.scootop.model.user.domain.FicheJoueurDTO;
import com.projet.scootop.model.user.domain.PlayerDTO;
import com.projet.scootop.model.user.domain.PlayerSearchListDTO;
import com.projet.scootop.model.user.domain.ScootDTO;
import com.projet.scootop.service.user.domain.ChairmanService;
import com.projet.scootop.service.user.domain.CoachService;
import com.projet.scootop.service.user.domain.PlayerService;
import com.projet.scootop.service.user.domain.ScootService;

@RequestMapping("/user/domain")
@RestController
public class UserDomainController {
	
	@Autowired private PlayerService playerService;
	@Autowired private ChairmanService chairmanService;
	@Autowired private ScootService scootService;
	@Autowired private CoachService coachService;

	
	//GET ALL
	@GetMapping("/chairmens")
    List<ChairmanDTO> getAllChairmen(){
        return chairmanService.getAll();
    }
    
    @GetMapping("/scoots")
    List<ScootDTO> getAllScoots(){
        return scootService.getAll();
    }
    
    // **** MatchSheet Data return List of Avalaible Scoot ****
    @GetMapping("/matchsheet/{matchsheetsId}/scoots")
    @ResponseBody
    List<ScootDTO> getAllByScootByMatchSheetId(@PathVariable("matchsheetsId") Long matchId){
        return scootService.getAllByMatchSheetId(matchId);
    }
    
    @GetMapping("/players")
    List<PlayerDTO> getAllPlayers(){
        return playerService.getAll();
    }
    
    @GetMapping("/players/search")
    List<PlayerSearchListDTO> searchPlayers(@RequestBody SearchPlayer params) throws JsonProcessingException{
    	return playerService.searchPlayers(params);
    }

    @GetMapping("/player/comparator")
    List<FicheJoueurDTO> getComparator(@RequestBody ComparatorParamsDTO params){
    	return playerService.compareTwoPlayers(params);
    }
    
    @GetMapping("/coaches")
    List<CoachDTO> getAllCoaches(){
        return coachService.getAll();
    }
    
    
    
    
	//GET ONE
    @GetMapping("/chairman/{id}")
    ChairmanDTO getChairman(@PathVariable("id") Long id) throws Exception{
        return chairmanService.get(id);
    }
    
    @GetMapping("/scoot/{id}")
    ScootDTO getScoot(@PathVariable Long id){
        return scootService.get(id);
    }
    
    @GetMapping("/player/{id}")
    PlayerDTO getPlayer(@PathVariable Long id){
        return playerService.get(id);
    }
    
    @GetMapping("/player/fiche")
	FicheJoueurDTO getFicheJoueur(@RequestBody ComparatorParamsDTO params) {
		return playerService.getUserResume(params);
	}
    
    @GetMapping("/coach/{id}")
    CoachDTO getCoach(@PathVariable Long id){
        return coachService.get(id);
    }
    
    
    
    
    
	//CREATE
    @PostMapping("/chairman")
    ChairmanDTO addChairman(@RequestBody ChairmanDTO body) throws Exception{
        return chairmanService.add(body);
    }
    
    @PostMapping("/scoot")
    ScootDTO postScoot(@RequestBody ScootDTO body) throws Exception{
        return scootService.add(body);
    }
    
    @PostMapping("/player")
    PlayerDTO addPlayer(@RequestBody PlayerDTO body){
        return playerService.add(body);
    }
    
    @PostMapping("/coach")
    CoachDTO addCoach(@RequestBody CoachDTO body) throws Exception {
        return coachService.add(body);
    }
    
    
    
    
	
	//UPDATE
    @PutMapping("/chairman/{id}")
    ChairmanDTO updateChairman(@RequestBody ChairmanDTO body, @PathVariable Long id) throws Exception {
        return chairmanService.update(body);
    }
    
    @PutMapping("/scoot/{id}")
    ScootDTO updateScoot(@RequestBody ScootDTO body, @PathVariable Long id) throws Exception {
        return scootService.update(body);
    }
    
    @PutMapping("/player/{id}")
    PlayerDTO updatePlayer(@RequestBody PlayerDTO body, @PathVariable Long id){
        return playerService.update(body);
    }
    
    @PutMapping("/coach/{id}")
    CoachDTO updateCoach(@RequestBody CoachDTO body, @PathVariable Long id) throws Exception {
        return coachService.update(body);
    }
    
    
    
	
	//DELETE 
    @DeleteMapping("/chairman/{id}")
    String deleteChairman(@PathVariable("id") Long id) {
        return chairmanService.delete(id);
    }

    @DeleteMapping("/scoot/{id}")
    String deleteScoot(@PathVariable("id") Long id) {
        return scootService.delete(id);
    }
    
    @DeleteMapping("/player/{id}")
    String deletePlayer(@PathVariable Long id){
        return playerService.delete(id);
    }
    
    @DeleteMapping("/coach/{id}")
    String deleteCoach(@PathVariable Long id){
        return coachService.delete(id);
    }
    
    
    
    
   
}
